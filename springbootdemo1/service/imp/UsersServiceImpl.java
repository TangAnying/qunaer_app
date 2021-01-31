package com.demo.springbootdemo.service.imp;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.demo.springbootdemo.entity.Users;
import com.demo.springbootdemo.repository.UsersRepository;
import com.demo.springbootdemo.service.UserService;
import com.demo.springbootdemo.util.MyUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

//接口的实现类
@Service
public class UsersServiceImpl implements UserService {

    @Resource
    private UsersRepository usersRepository;//spring自动注入
    //注册
    @Override
    public Users reg(Users user) {
        //用户注册的时候必须对明文的密码进行加密。自动注册日期写入数据库中。
        user.setPassword(MyUtil.encodeStringByMd5(user.getPassword()));
        //保存注册日期
        user.setRegDate(MyUtil.utilDtaeToChineseString(new Date()));
        //根据手机号码生成一个默认的用户名
        user.setUsername(MyUtil.RamdonmUsername(user.getMobile()));

        int result = usersRepository.insert(user);
        if(result>0){
            //usersRepository.selectById(user.getUid())
            //
            System.out.println("新用户的编号是："+user.getId());
            return usersRepository.selectById(user.getId()); //如果注册成功返回注册成功的用户对象。
        }
        return null; //如果注册失败返回一个空对象。
    }
    //登录
    @Override
    public Users login(String identify, String password) {
        //判断登录类型
        QueryWrapper<Users> wrapper = new QueryWrapper<Users>();
        switch (MyUtil.checkIdentifyType(identify)){
            case MOBILE:
                wrapper.eq("mobile",identify).eq("password",MyUtil.encodeStringByMd5(password));
                break;
            case EMAIL:
                wrapper.eq("email",identify).eq("password",MyUtil.encodeStringByMd5(password));
                break;
            case USERNAME:
                wrapper.eq("username",identify).eq("password",MyUtil.encodeStringByMd5(password));
                break;
        }
        return usersRepository.selectOne(wrapper);
    }

    @Override
    public Users queryUserById(int id) {
        return usersRepository.selectById(id);
    }

    @Override
    public Users updateUser(Users user) {
        usersRepository.updateById(user);
        return user;
    }

    @Override
    public boolean deleteUser(int id) {
        int result = usersRepository.deleteById(id);
        if(result > 0)
            return true;
        return false;
    }
    @Override
    public List<Users> queryAllUsers() {
        return usersRepository.selectList(null);
    }

    @Override
    public boolean checkMobileIsExit(String mobile) {
        QueryWrapper<Users> wrapper = new QueryWrapper<Users>();
        wrapper.eq("mobile",mobile);
        List<Users>users = usersRepository.selectList(wrapper);
        if(users!=null&&users.size()>0)
            return true;
        return false;
    }

}

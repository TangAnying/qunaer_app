package com.demo.springbootdemo.service.imp;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.demo.springbootdemo.entity.Favorite;
import com.demo.springbootdemo.repository.FavoriteRepository;
import com.demo.springbootdemo.service.FavoriteService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class FavoriteSerivceImpl implements FavoriteService {
    @Resource
    FavoriteRepository favoriteRepository;

    @Override
    public Favorite add(int userid,int productid,String title,int price) {
        Favorite favorite = new Favorite();
        favorite.setProductid(productid);
        favorite.setUserid(userid);
        favorite.setPrice(price);
        favorite.setTitle(title);
        int result = favoriteRepository.insert(favorite);
        if(result>0){
            //usersRepository.selectById(user.getUid())
            //
            System.out.println("新用户的编号是："+favorite.getId());
            return favoriteRepository.selectById(favorite.getId()); //如果注册成功返回注册成功的用户对象。
        }
        return null; //如果注册失败返回一个空对象。
    }

    @Override
    public boolean delete(int id) {
        int result = favoriteRepository.deleteById(id);
        if(result>0)
        {
            return true; //如果注册成功返回注册成功的用户对象。
        }
        return false; //如果注册失败返回一个空对象。
    }

    @Override
    public List<Favorite> search(int uid) {
        QueryWrapper<Favorite> queryWrapper = new QueryWrapper<Favorite>();
        queryWrapper.like("userid",uid);
        List<Favorite> favoriteList = favoriteRepository.selectList(queryWrapper);
        return favoriteList;
    }

    @Override
    public boolean checkFavoriteIsExit(int userid, int productid) {
        QueryWrapper<Favorite> wrapper = new QueryWrapper<Favorite>();
        wrapper.eq("userid",userid).eq("productid",productid);
        List<Favorite>favorites = favoriteRepository.selectList(wrapper);
        if(favorites!=null&&favorites.size()>0)
            return true;
        return false;
    }
}

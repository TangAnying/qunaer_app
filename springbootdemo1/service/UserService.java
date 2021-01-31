package com.demo.springbootdemo.service;

import com.demo.springbootdemo.entity.Users;

import java.util.List;

public interface UserService {
    //注册
    public Users reg(Users user);
    //登录
    public Users login(String identify,String password);
    //查询
    public Users queryUserById(int id);
    //更新
    public Users updateUser(Users user);
    //删除
    public boolean deleteUser(int id);
    //查询所用用户的
    public List<Users> queryAllUsers();
    //查重手机号
    public boolean checkMobileIsExit(String mobile);
}

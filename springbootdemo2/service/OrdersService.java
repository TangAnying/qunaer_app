package com.example.springbootdemo.service;

import com.example.springbootdemo.entity.UserOrders;

import java.util.List;

public interface OrdersService {

    //增加订单
    public UserOrders ordersAdd(UserOrders userOrders);

    //根据id删除订单
    public boolean deleteOrderById(String oid);

    //获取用户的全部订单
    public List<UserOrders> queryOrders(int uid);

}

package com.example.springbootdemo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.springbootdemo.entity.UserOrders;
import com.example.springbootdemo.repository.OrdersRepository;
import com.example.springbootdemo.service.OrdersService;
import com.example.springbootdemo.util.IDUtils;
import com.example.springbootdemo.util.MyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private OrdersRepository ordersRepository;
    //增加订单
    @Override
    public UserOrders ordersAdd(UserOrders userOrders) {
        //保存注册日期
        userOrders.setOrderTime(MyUtil.utilDateToChineseString(new Date()));
        // 时间戳+随机数生成唯一订单ID
        userOrders.setOid(IDUtils.createID());
        int result = ordersRepository.insert(userOrders);
        System.out.println(result);
        if(result>0){
            //如果注册成功返回注册成功的订单对象。
            return ordersRepository.selectById(userOrders.getId());
        }
        return null; //如果注册失败返回一个空对象。
    }

    @Override
    public boolean deleteOrderById(String oid) {
        return false;
    }
    //获取用户的全部订单
    @Override
    public List<UserOrders> queryOrders(int uid) {
        QueryWrapper<UserOrders> queryWrapper =new QueryWrapper<UserOrders>();
        queryWrapper.like("uid",uid);
        List<UserOrders> orders=ordersRepository.selectList(queryWrapper);
        return orders;
    }
}

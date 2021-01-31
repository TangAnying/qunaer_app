package com.example.springbootdemo.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springbootdemo.entity.UserOrders;
import org.springframework.stereotype.Repository;

//订单
@Repository
public interface OrdersRepository extends BaseMapper<UserOrders> {
}

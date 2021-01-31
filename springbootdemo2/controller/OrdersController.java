package com.example.springbootdemo.controller;

import com.example.springbootdemo.entity.UserOrders;
import com.example.springbootdemo.service.OrdersService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("orders")
public class OrdersController {
    @Resource
    private OrdersService ordersService;
    @PostMapping("/")
    public Map<String, Object> ordersAdd(@RequestBody UserOrders userOrders) {

        System.out.println("要注册的用户资料是：" + userOrders);
        Map<String, Object> result = new HashMap<String, Object>();


        UserOrders addOrder = ordersService.ordersAdd(userOrders);

        if (addOrder != null) {
            result.put("code", 200);
            result.put("data", addOrder);
            result.put("msg", "addSuccess");
        } else {
            result.put("code", 400);
            result.put("data", null);
            result.put("msg", "程序出现异常，订单购买失败！");
        }
        return result;
    }
    @GetMapping("orderlist")
    public Map<String,Object> queryOrders(int uid) {
        Map<String, Object> result = new HashMap<String, Object>();

        List<UserOrders> orders=ordersService.queryOrders(uid);
        if (orders != null) {
            result.put("code", 200);
            result.put("data", orders);
            result.put("msg", "querySuccess");
        } else {
            result.put("code", 400);
            result.put("data", null);
            result.put("msg", "程序出现异常，失败！");
        }
        return result;
    }
}

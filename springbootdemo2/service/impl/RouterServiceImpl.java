package com.example.springbootdemo.service.impl;

import com.example.springbootdemo.entity.Router;
import com.example.springbootdemo.repository.RouterRepository;
import com.example.springbootdemo.service.RouterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RouterServiceImpl implements RouterService {
    @Autowired
    private RouterRepository routerRepository;


    //添加路径
    @Override
    public int saveRouter(Router router) {
        return this.routerRepository.insert(router);
    }
    //根据路线ID查询路径
    @Override
    public Router queryRouterById(int id) {
        return routerRepository.selectById(id);
    }
}
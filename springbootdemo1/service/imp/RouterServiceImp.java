package com.demo.springbootdemo.service.imp;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.demo.springbootdemo.entity.Router;
import com.demo.springbootdemo.repository.RouterRepository;
import com.demo.springbootdemo.service.RouterService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class RouterServiceImp implements RouterService {
    @Resource
    private RouterRepository routerRepository;
    @Override
    public Router add() {
        return null;
    }

    @Override
    public List<Router> search(String city) {
        QueryWrapper<Router> queryWrapper = new QueryWrapper<Router>();
        queryWrapper.like("city",city);
        List<Router> RouterList = routerRepository.selectList(queryWrapper);
        return RouterList;
    }

    @Override
    public List<Router> listall() {
        System.out.println("sucess!");
        return routerRepository.selectList(null);
    }
}

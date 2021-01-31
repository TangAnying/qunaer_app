package com.demo.springbootdemo.service;

import com.demo.springbootdemo.entity.Router;

import java.util.List;

public interface RouterService {
    public Router add();
    public List<Router> search(String city);
    public List<Router> listall();
}

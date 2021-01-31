package com.example.springbootdemo.service;

import com.example.springbootdemo.entity.Router;

public interface RouterService {
    //添加一个旅游线路
    public int saveRouter(Router router);

    //根据线路编号查询线路
    public Router queryRouterById(int id);




}

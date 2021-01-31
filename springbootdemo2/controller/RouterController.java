package com.example.springbootdemo.controller;

import com.example.springbootdemo.entity.Router;
import com.example.springbootdemo.service.RouterService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("router")
public class RouterController {
    @Resource
    private RouterService routerService;
    @GetMapping("line")
    public Map<String, Object> queryUserByUid(int id) {
        Map<String, Object> result = new HashMap<String, Object>();
        Router router = routerService.queryRouterById(id);
        if (router != null) {
            result.put("code", 200);
            result.put("data", router);
            result.put("msg", "querySuccess");
        } else {
            result.put("code", 400);
            result.put("data", null);
            result.put("msg", "queryFailure");
        }
        return result;
    }
}

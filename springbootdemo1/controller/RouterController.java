package com.demo.springbootdemo.controller;

import com.demo.springbootdemo.entity.Router;
import com.demo.springbootdemo.service.RouterService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("router")
public class RouterController {
    @Resource
    private RouterService routerService;

    @GetMapping("/listall")
    public Map<String,Object> showall() {
        Map<String, Object> result = new HashMap<String, Object>();
        List<Router> routers = routerService.listall();
        if (routers != null) {
            result.put("code", 200);
            result.put("data", routers);
            result.put("msg", "regSuccess");
        } else {
            result.put("code", 400);
            result.put("data", null);
            result.put("msg", "程序出现异常，失败！");
        }
        return result;
    }
    @GetMapping("/")
    public Map<String,Object> search(@RequestBody(required=false) String city) {
        Map<String, Object> result = new HashMap<String, Object>();
        List<Router> routers = routerService.search(city);
        if (routers != null) {
            result.put("code", 200);
            result.put("data", routers);
            result.put("msg", "regSuccess");
        } else {
            result.put("code", 400);
            result.put("data", null);
            result.put("msg", "程序出现异常，失败！");
        }
        return result;
    }
    }

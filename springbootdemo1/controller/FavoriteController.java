package com.demo.springbootdemo.controller;

import com.demo.springbootdemo.entity.Favorite;
import com.demo.springbootdemo.service.FavoriteService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("favorites")
public class FavoriteController {
    @Resource
    private FavoriteService favoriteService;
    @PostMapping("add/{userid}/{productid}/{price}")
    public Map<String,Object> add(@PathVariable("userid")int userid,@PathVariable("productid")int productid,@PathVariable("price")int price,@RequestBody(required=false) String title){
        Map<String, Object> result = new HashMap<String, Object>();

        if (favoriteService.checkFavoriteIsExit(userid, productid))
        {
            result.put("code", 400);
            result.put("data", null);
            result.put("msg", "已经收藏过了哦!");
        }
        else
        {
            Favorite favorites = favoriteService.add(userid, productid,title,price);

            if (favorites != null) {
                result.put("code", 200);
                result.put("data", favorites);
                result.put("msg", "regSuccess");
            } else {
                result.put("code", 400);
                result.put("data", null);
                result.put("msg", "程序出现异常，注册失败！");
            }
        }
        return result;
    }
    @DeleteMapping("del/{id}")
    public Map<String,Object> deletefavorite(@PathVariable("id") int id) {
        Map<String, Object> result = new HashMap<String, Object>();
        boolean favorites = favoriteService.delete(id);
        if (favorites != false) {
            result.put("code", 200);
            result.put("data", favorites);
            result.put("msg", "regSuccess");
        } else {
            result.put("code", 400);
            result.put("data", null);
            result.put("msg", "程序出现异常，失败！");
        }
        return result;
    }
    @GetMapping("/{userid}")
    public Map<String,Object> search(@PathVariable("userid")int userid) {
        Map<String, Object> result = new HashMap<String, Object>();
        List<Favorite> favorites = favoriteService.search(userid);
        if (favorites != null) {
            result.put("code", 200);
            result.put("data", favorites);
            result.put("msg", "regSuccess");
        } else {
            result.put("code", 400);
            result.put("data", null);
            result.put("msg", "程序出现异常，失败！");
        }
        return result;
    }
}

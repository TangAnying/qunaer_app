package com.demo.springbootdemo.service;

import com.demo.springbootdemo.entity.Favorite;

import java.util.List;

public interface FavoriteService {
    public Favorite add(int userid,int productid,String title,int price);

    public boolean delete(int id);

    public List<Favorite> search(int userid);

    public boolean checkFavoriteIsExit(int userid,int productid);
}

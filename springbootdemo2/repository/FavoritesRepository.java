package com.example.springbootdemo.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springbootdemo.entity.Favorites;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoritesRepository extends BaseMapper<Favorites> {
}

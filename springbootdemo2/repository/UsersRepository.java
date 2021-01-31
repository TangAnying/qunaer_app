package com.example.springbootdemo.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springbootdemo.entity.Users;
import org.springframework.stereotype.Repository;

//接口可以继承接口
@Repository
public interface UsersRepository extends BaseMapper<Users> {
}

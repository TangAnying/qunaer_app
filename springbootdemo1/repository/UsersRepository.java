package com.demo.springbootdemo.repository;

import org.springframework.stereotype.Repository;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.demo.springbootdemo.entity.Users;
@Repository
public interface UsersRepository extends BaseMapper<Users> {//接口继承接口，不能直接用，通过服务层调用

}

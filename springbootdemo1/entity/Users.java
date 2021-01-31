package com.demo.springbootdemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity//实体类直接映射为一张表
@Data//getter,setter,toString,hashCode,equeals
@AllArgsConstructor//自动构造方法
@NoArgsConstructor

public class Users {
//所有属性均是私有的
    @Id//主键
    @GeneratedValue(strategy = GenerationType.IDENTITY) //使用默认的主键生成策略 auto_increment
    @TableId(value = "id",type = IdType.AUTO)
    private int id;
    private String username;
    @Column(length = 11)
    private String mobile;
    private String email;
    private String password;
    @Column(length = 2)
    private String gender;//默认255
    private String birthday;
    private String regDate;//注册日期
    private int status;//1可用，0禁用
    private String img;

}

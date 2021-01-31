package com.demo.springbootdemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity//实体类直接映射为一张表
@Data//getter,setter,toString,hashCode,equeals
@AllArgsConstructor//自动构造方法
@NoArgsConstructor
public class Favorite {
    @Id//主键
    @GeneratedValue(strategy = GenerationType.IDENTITY) //使用默认的主键生成策略 auto_increment
    @TableId(value = "id",type = IdType.AUTO)
    private int id;
    private int userid;
    private int productid;
    private String title;
    private int price;
}
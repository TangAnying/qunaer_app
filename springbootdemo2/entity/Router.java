package com.example.springbootdemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

//旅游线路表
@Entity
@Data //自动生成getter/setter toString hashCode equals
@AllArgsConstructor //自动生成带所有参数的构造方法
@NoArgsConstructor //自动生成默认不带参数的构造方法
public class Router implements Serializable,Cloneable {

    //表必须有主键
    @Id //表示是主键
    @GeneratedValue(strategy = GenerationType.IDENTITY) //使用默认的主键生成策略 auto_increment
    @TableId(value = "id",type = IdType.AUTO)
    private int id; //旅游线路的编号，自动递增的。
    //将来我可以根据省份和城市来查询对应的旅游线路.
    private String province ; //所在的省份
    private String city; //所在的城市
    private String name; //旅游线路的名称 ，故宫一日游
    private String shopName; //商家的名称，将来肯定要设计一个商家表。
    private String shopId; //商家的id;
    private int price; //价格
    private String introduce; //线路的详细介绍。这里有可能包含各种html标签。富文本。
    private String pics; //该旅游线路的轮播图片集合。'oldplace001.jpg,oldplace002.jpg,oldplace003.jpg,oldplace004.jpg,oldplace005.jpg'



}

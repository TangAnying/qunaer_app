package com.example.springbootdemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

//订单表
@Entity
@Data //自动生成getter/setter toString hashCode equals
@AllArgsConstructor //自动生成带所有参数的构造方法
@NoArgsConstructor //自动生成默认不带参数的构造方法
public class UserOrders implements Serializable,Cloneable{


    @Id //表示是主键
    @GeneratedValue(strategy = GenerationType.IDENTITY) //使用默认的主键生成策略 auto_increment
    @TableId(value = "id",type = IdType.AUTO)
    private int id; //旅游线路的编号，自动递增的。
    private String oid; //订单编号,设计一个订单编号的生成算法。
    private int uid; //用户编号
    private String routerId; //对应的旅游线路的编号
    private String realName; //真实姓名
    private String mobile; //手机号码
    private String cardId; //身份证号码
    private String memo; //备注
    private String orderTime; //订单日期
    private int totalPrice; //价格
    private int number; //数量
    private int status; //状态，1.未付款  2.已付款 3.已完成
}

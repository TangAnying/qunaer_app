package com.demo.springbootdemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity//实体类直接映射为一张表
@Data//getter,setter,toString,hashCode,equeals
@AllArgsConstructor//自动构造方法
@NoArgsConstructor
public class Router {
    @Id//主键
    //@GeneratedValue(strategy = GenerationType.IDENTITY) //使用默认的主键生成策略 auto_increment
    @TableId(value = "rid",type = IdType.AUTO)
    private int rid;
    private String province;
    private String city;
    private String title;//旅游线路名称
    private String shopName;
    private String shopId;
    private int originalPrice;
    private int favourPrice;
    private String img;
}

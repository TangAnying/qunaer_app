package com.example.springbootdemo.util;

import cn.hutool.core.lang.UUID;
import cn.hutool.core.lang.Validator;
import cn.hutool.crypto.SecureUtil;
import sun.plugin.util.UIUtil;

import java.text.SimpleDateFormat;
import java.util.Date;
public class MyUtil {
    //使用MD5加密算法对字符串进行加密。
    public static String encodeStringByMd5(String src){
        return SecureUtil.md5(src);
    }

    //生成默认中文格式的日期字符串
    public static String utilDateToChineseString(Date date){
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
    }

    //每次随机生成一个不重复的用户名
    public static String generateRadnomUsername(String mobile){
        return UUID.nameUUIDFromBytes(mobile.getBytes()).toString().replaceAll("-","");
    }

    //判断是否电子邮箱
    public static IdentifyType checkIdentifyType(String identify){
        if(Validator.isEmail(identify)){
            return IdentifyType.EMAIL;
        }else if(Validator.isMobile(identify)){
            return IdentifyType.MOBILE;
        }else{
            return IdentifyType.USERNAME;
        }
    }

    /*
    public static String encodeStringByHmacMd5(String src){
        return SecureUtil.hmacMd5(src).;
    }*/

    public static void main(String[] args) {

        //System.out.println(MyUtil.encodeStringByMd5("123456"));

        //System.out.println(MyUtil.checkIdentifyType("haha_1999"));
    }
}

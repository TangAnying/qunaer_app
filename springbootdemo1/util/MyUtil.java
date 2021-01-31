package com.demo.springbootdemo.util;

import cn.hutool.core.lang.Validator;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.digest.HMac;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class MyUtil {
    //MD5加密
    public static String encodeStringByMd5(String src){
        return SecureUtil.md5(src);
    }
    //hacMd5
    public static HMac encodeStringByHmaMd5(String src){
        return SecureUtil.hmacMd5(src);
    }
    //日期
    public static String utilDtaeToChineseString(Date date){
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
    }
    //随机用户名
    public static String RamdonmUsername(String mobile){
        return UUID.nameUUIDFromBytes(mobile.getBytes()).toString();
    }
    //判断是否是哪一种登录方式电子邮箱/电话号码/用户名
    public static IdentifyType checkIdentifyType(String identify){
        if(Validator.isEmail(identify))
            return IdentifyType.EMAIL;
        else if(Validator.isMobile(identify))
            return IdentifyType.MOBILE;
        else
            return IdentifyType.USERNAME;
    }
    public static void main(String[] args) {
        System.out.println(MyUtil.encodeStringByHmaMd5("123456"));
    }
}

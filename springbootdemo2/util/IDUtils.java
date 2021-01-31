package com.example.springbootdemo.util;

public class IDUtils {
    private static byte[] lock = new byte[0];

    // 时间戳+随机数生成唯一订单ID
    private final static long w = 100000000;

    public static String createID() {
        long r = 0;
        synchronized (lock) {
            r = (long) ((Math.random() + 1) * w);
        }

        return System.currentTimeMillis() + String.valueOf(r).substring(1);
    }

}

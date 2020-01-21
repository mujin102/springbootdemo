package com.dongqtai.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/*
    Http工具类
 */
public class HttpUtil {
    /*
        http工具类法的设计通常情况采用“单利模式”（由于是工具类，所以，采用单利模式）
        此处使用单利模式中的 “静态内部类模式”实现单例模式。
        并利用http连接池

     */
    private static final Logger logger = LoggerFactory.getLogger(HttpUtil.class); // 日志管理

    private HttpUtil(){

    } // 外部类构造方法私有

    private static class HttpUtilHolder{  // 构建私有静态内部类
        private static final HttpUtil INSTANCE  = new HttpUtil();  // 私有静态内部类包括一个私有静态外部类对象成员变量
    }

    public static HttpUtil getInstance(){ // 外部类的公共静态方法，该方法返回内部私有静态类的成员变量
        return HttpUtilHolder.INSTANCE;
    }

}

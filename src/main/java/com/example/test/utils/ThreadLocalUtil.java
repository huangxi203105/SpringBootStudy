package com.example.test.utils;

/**
 * @author hx on 2025/4/5
 */
public class ThreadLocalUtil {
    private static final ThreadLocal<Object> threadLocal = new ThreadLocal<>();

    //根据健获取值
    public static <T>T get(){
        return (T) threadLocal.get();
    }

    //存储键值对
    public static void set(Object value){
        threadLocal.set(value);
    }
    public static void remove(){
        threadLocal.remove();
    }
}

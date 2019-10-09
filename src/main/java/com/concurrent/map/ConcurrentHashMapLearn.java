package com.concurrent.map;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName ConcurrentHashMapLearn
 * @Author chenzhuo
 * @Version 1.0
 * @Date 2019-08-20 22:40
 **/
public class ConcurrentHashMapLearn {

    public static void main(String[] args) {
        ConcurrentHashMap<String, String> concurrentHashMap
                = new ConcurrentHashMap(16);
        concurrentHashMap.put("hhhh", "cccc");
        System.err.println(concurrentHashMap.entrySet());
    }
}

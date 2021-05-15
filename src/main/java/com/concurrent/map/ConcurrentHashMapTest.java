package com.concurrent.map;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Hikari
 * @version 1.0.0
 * @ClassName ConcurrentHashMapTest.java
 * @createTime 2021年02月02日 22:22:00
 */
public class ConcurrentHashMapTest {

    public static void main(String[] args) {
        ConcurrentHashMap<String, Object> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("测试", "陈胖子");

    }
}

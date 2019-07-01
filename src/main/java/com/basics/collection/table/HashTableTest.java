package com.basics.collection.table;

import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName HashTableTest
 * @Author chenzhuo
 * @Version 1.0
 * @Date 2019-05-08 22:57
 **/
public class HashTableTest {

    public static void main(String[] args) {
        Hashtable<String,String> hashtable = new Hashtable<>();
        hashtable.put("","");
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.get("");
    }
}

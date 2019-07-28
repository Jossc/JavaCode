package com.basics.juctest.basicsThread;

import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName TestHashMap
 * @Description TODO
 * @Author chenzhuo
 * @Date 2018/10/23 22:27
 * @Version 1.0
 **/
public class TestHashMap {
    public static void main(String[] args) throws InterruptedException {
        final HashMap<String,String>
                 map = new HashMap<>(2);
        Thread t = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                new Thread(() -> map.put(UUID.randomUUID().toString(), ""), "fff" + i).start();
            }
        }, "fff天团");
        t.start();
        t.join();

        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();



    }
}

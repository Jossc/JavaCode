package com.concurrent.cyclicbarrierlearn.map;

import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author by chenzhuo
 * @Description
 * @Date 2019/7/3 13:45
 **/
public class HashMapTest {

    public static HashMap hashMap = new HashMap(2);

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 1; i <= 100000; i++) {
                int result = i;
                new Thread(() -> hashMap.put(result, result), "cc" + i).start();
            }

        });
        t1.start();
        Thread.sleep(5000);
        System.err.println("11");
        for (int i = 1; i <= 100000; i++) {
            Integer value = (Integer) hashMap.get(i);
            if (value == null) {
                System.out.println(i + "数据丢失");
            }
        }
    }
}

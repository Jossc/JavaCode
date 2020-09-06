package com.concurrent.thread.wait;

import com.jvm.bytecode.A;

/**
 * @author 一方通行
 * @title: CountTest
 * @projectName JavaCode
 * @date 2020/8/28 17:37
 */
public class CountTest {

    private static int count = 0;

    private static Object lock = new Object();

    public static void main(String[] args) {
        Thread addCount = new Thread(() -> {
            addCount();
        });

        Thread subtractionCount = new Thread(() -> {
            try {
                subtractionCount();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        addCount.start();
        subtractionCount.start();

    }


    public static void addCount() {
        synchronized (lock) {
            count++;
            System.out.println(count);
            lock.notify();
        }
    }

    public static void subtractionCount() throws InterruptedException {
        synchronized (lock) {
            count--;
            System.out.println(count);
            lock.wait();
        }
    }

}

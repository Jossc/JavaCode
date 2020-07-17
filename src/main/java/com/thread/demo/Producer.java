package com.thread.demo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author Hikari
 * @version 1.0.0
 * @ClassName Producer.java
 * @createTime 2020年07月17日 22:04:00
 */
public class Producer implements Runnable {
    public volatile boolean canceled = false;
    ArrayBlockingQueue storage;

    public Producer(ArrayBlockingQueue storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        int num = 0;
        int max = 100000;
        try {
            while (num <= max && !Thread.currentThread().isInterrupted()) {
                if (num % 50 == 0) {
                    storage.put(num);
                    System.out.println("50的倍数 ：" + num);
                }
                num++;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("运行结束");
        }


    }
}

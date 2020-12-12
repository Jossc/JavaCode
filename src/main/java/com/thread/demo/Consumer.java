package com.thread.demo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

/**
 * @author Hikari
 * @version 1.0.0
 * @ClassName Consumer.java
 * @createTime 2020年07月17日 22:10:00
 */
public class ConsumerConsumer {

    ArrayBlockingQueue storage;

    public Consumer(ArrayBlockingQueue storage) {
        this.storage = storage;
    }

    public boolean getValue() {
        float defValue = 0.77f;
        if (Math.random() > defValue) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue store = new ArrayBlockingQueue(8);
        Producer producer = new Producer(store);
        Thread producerThread = new Thread(producer);
        producerThread.start();
        Thread.sleep(500);
        Consumer consumer = new Consumer(store);
        while (consumer.getValue()) {
            System.out.println("哈哈哈 开始消费了" + consumer.storage.take());
            Thread.sleep(100);
        }
        System.out.println("消费结束了");
        /* producer.canceled = true;*/
        producerThread.interrupt();
        System.out.println(producer.canceled);

    }
}

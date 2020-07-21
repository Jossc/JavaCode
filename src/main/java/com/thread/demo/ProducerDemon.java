package com.thread.demo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author crazy
 * @title: ProducerDemon
 * @projectName JavaCode
 * @description: 生产和消费者模式
 * @date 2020/7/20 11:35
 */
public class ProducerDemon {


    public static void main(String[] args) {
        BlockingQueue<String> blockingDeque = new ArrayBlockingQueue(10);
        Runnable producer = () -> {
            while (true) {
                try {
                    blockingDeque.put("哈哈");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        new Thread(producer).start();
        new Thread(producer).start();

        Runnable consumer = () -> {
            while (true) {
                try {
                    System.out.println(blockingDeque.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        new Thread(consumer).start();
        new Thread(consumer).start();
    }
}

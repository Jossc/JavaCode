package com.thread.demo;


import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Hikari
 * @version 1.0.0
 * @ClassName WaitMethodTest.java
 * @createTime 2020年07月19日 21:22:00
 */
public class WaitMethodTest {

    public Queue<String> blockingQueue = new LinkedList<>();

    public static void main(String[] args) {
        WaitMethodTest waitMethodTest = new WaitMethodTest();
        Runnable threadOne = () -> {
            String putValue = "value";
            waitMethodTest.put(putValue);
        };
        Runnable threadTwo = () -> {
            String getValue = waitMethodTest.get();
            System.out.println(getValue);
        };
        Thread putThread = new Thread(threadOne);
        putThread.setName("putValueThread");
        Thread getThread = new Thread(threadTwo);
        getThread.setName("getValueThread");
        putThread.start();
        getThread.start();

    }

    public void put(String value) {
        blockingQueue.add(value);
        //唤醒等待的第一个
        notify();
    }

    public String get() {
        while (blockingQueue.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("哈哈的 等待超时");
            }
        }
        return blockingQueue.remove();
    }
}

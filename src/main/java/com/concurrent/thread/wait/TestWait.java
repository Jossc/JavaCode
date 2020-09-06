package com.concurrent.thread.wait;

/**
 * @author 一方通行
 * @title: TestWait
 * @projectName JavaCode
 * @date 2020/8/27 15:55
 */
public class TestWait {

    public static void main(String[] args) throws InterruptedException {
        new  TestWait().ss();
    }

    public synchronized void  ss () throws InterruptedException {
        wait();
    }
}

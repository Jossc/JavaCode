package com.thread.demo;

import lombok.SneakyThrows;

/**
 * @author crazy
 * @title: ThreadStatusTest
 * @projectName JavaCode
 * @description: TODO
 * @date 2020/7/18 15:02
 */
public class ThreadStatusTest {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new ThreadStatus());
        System.out.println("new Thread status :" + thread.getState());
        thread.setName("thead name is test");
        System.out.println("main thread start run");
        System.out.println("main thead status :" + Thread.currentThread().getState());
        Thread.sleep(20000);
        System.out.println("main thead status :" + Thread.currentThread().getState());
        System.out.println("thead status :" + thread.getState());
        thread.start();
        System.out.println("哈哈");

    }

    private static class ThreadStatus implements Runnable {
        @SneakyThrows
        @Override
        public void run() {
            System.out.println("thread runnable ");
            System.out.println("thead status :" + Thread.currentThread().getState());
            Thread.sleep(2000);
        }
    }
}

package com.concurrent.threapoollearn;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author by chenzhuo
 * @Description 线程池测试2
 * @Date 2019/6/12 20:34
 **/
public class TheadPoolTestTwo {

    public static void main(String[] args) {
        ExecutorService executors = Executors.newCachedThreadPool();
        executors.submit(new Run());
    }


    public static class Run implements Runnable {

        @Override
        public void run() {
            try {
                int count = 0;
                while (true) {
                    count++;
                    System.out.println(count);
                    if (count == 10) {
                        System.out.println(1 / 0);
                    }
                }
            } catch (Exception e) {
                System.err.println("111");
            }
            System.err.println("222");
        }
    }
}

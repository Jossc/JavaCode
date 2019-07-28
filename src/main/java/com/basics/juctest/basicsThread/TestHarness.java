package com.basics.juctest.basicsThread;

import java.util.concurrent.CountDownLatch;

/**
 * @ClassName TestHarness
 * @Description TODO
 * @Author chenzhuo
 * @Date 2018/10/29 21:42
 * @Version 1.0
 **/
public class TestHarness {

    public long timeTasks(int nThreads,final Runnable task) throws InterruptedException {

        final CountDownLatch start
                = new CountDownLatch(1);
        final CountDownLatch end
                = new CountDownLatch(nThreads);
         for(int i=0;i<nThreads;i++){
             Thread t = new Thread(()->{
                 try {
                     task.run();
                 }finally {
                     end.countDown();
                 }
                /* try {
                     start.await();
                     try {
                         task.run();
                     }finally {
                         end.countDown();
                     }

                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }*/
             });
             t.start();
         }
         long startTime = System.nanoTime();
      //   start.countDown();
         end.await();
         long endTime = System.nanoTime();
         return  endTime -startTime;
    }

    public static void main(String[] args) throws InterruptedException {
        TestHarness testHarness
                = new TestHarness();

        Thread thread
                = new Thread(()->{
                    for(int i=0;i<10;i++){
                        System.out.println(i);
                    };
        });
        testHarness.timeTasks(10,thread);

    }
}

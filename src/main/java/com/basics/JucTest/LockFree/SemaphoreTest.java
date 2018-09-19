package com.basics.JucTest.LockFree;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * PACKAGE_NAME: com.basics.JucTest.LockFree
 * MONTH_NAME_SHORT: 九月
 * USER: Clement
 * SemaphoreTest
 * see {@link Semaphore}
 **/
public class SemaphoreTest {
    public static void main(String[] args) {
        ExecutorService executorService
                 = Executors.newCachedThreadPool();
        //设置信号量同时执行的线程数是5
        final Semaphore semp = new Semaphore(5);
        // 模拟20个客户端访问
        for (int index = 0; index < 20; index++) {
            final int cout = index;
            Runnable run = () -> {
                try {
                    semp.acquire();
                    System.out.println("Access: " + cout);
                    Thread.sleep(1000);
                    //队里中有15个节点在等待 一次执行5个
                    System.out.println("getQueueLength: " +semp.getQueueLength());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semp.release();

                }
            };
            executorService.execute(run);
        }
        executorService.shutdown();
    }
}

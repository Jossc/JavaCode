package com.basics.juctest.LockFree;


import java.util.concurrent.Semaphore;

/**
 * PACKAGE_NAME: com.basics.juctest.LockFree
 * MONTH_NAME_SHORT: 九月
 * USER: Clement
 * SemaphoreTest
 * see {@link Semaphore}
 *  final int nonfairTryAcquireShared(int acquires) {
 *             for (;;) {
 *                 int available = getState();
 *                 int remaining = available - acquires;
 *                 if (remaining < 0 ||
 *                     compareAndSetState(available, remaining))
 *                     return remaining;
 *             }
 *         }
 *
 **/
public class SemaphoreTest {
    public static void main(String[] args) throws InterruptedException {
       /* ExecutorService executorService
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
                    System.out.println(String.format("[Thread-%s]任务id --- %s",Thread.currentThread().getId(),cout));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semp.release();

                }
            };
            executorService.execute(run);
        }
        executorService.shutdown();*/
        final Semaphore semp = new Semaphore(5);
        semp.acquire();
    }
    public void test(){

      /*  ExecutorService executorService
                = Executors.newCachedThreadPool();*/

    }
}

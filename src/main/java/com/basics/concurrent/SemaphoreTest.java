package com.basics.concurrent;

import java.util.concurrent.*;

/**
 * @Description TODO
 * @Date 2019/4/1 12:38
 * @Created by chenzhuo
 **/
public class SemaphoreTest {
    private final static Semaphore semaphore = new Semaphore(1, true);

    public static void main(String[] args) {

        ThreadPoolExecutor threadPoolExecutor = new
                ThreadPoolExecutor(10, 10, 0, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(100));
        SemaphoreThread semaphoreThread = new SemaphoreThread();
        threadPoolExecutor.execute(semaphoreThread);


    }

    private static class SemaphoreThread extends Thread {

        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println("time:" + System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
            }

        }
    }
}

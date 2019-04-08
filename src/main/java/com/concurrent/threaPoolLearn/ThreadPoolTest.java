package com.concurrent.threaPoolLearn;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName ThreadPoolTest
 * @Despacito TODO
 * @Author chenzhuo
 * @Version 1.0
 **/
public class ThreadPoolTest {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 2, 2,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(1), new DemonFactory());
        for (int i = 0; i < 2; i++) {
            threadPoolExecutor.execute(() -> {

                try {
                    System.out.println(Thread.currentThread().getName() + " hello word");
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        threadPoolExecutor.shutdown();
    }

    public class Run implements Runnable {
        @Override
        public void run() {
            System.out.println("hello word");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static class DemonFactory implements ThreadFactory {
        private final AtomicInteger poolNumber = new AtomicInteger(1);
        private final ThreadGroup group;
        private final AtomicInteger threadNumber = new AtomicInteger(1);
        private final String name;

        DemonFactory() {
            SecurityManager securityManager = System.getSecurityManager();
            group = (securityManager != null) ? securityManager.getThreadGroup()
                    : Thread.currentThread().getThreadGroup();
            name = "xiao pang-" + poolNumber.getAndIncrement() + " test ";
        }

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(group, r, name + threadNumber.getAndIncrement(), 0);

            return t;
        }
    }
}

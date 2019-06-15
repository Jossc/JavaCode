package com.selfrealization.threadpool;

import java.util.HashSet;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName SlefThreadPool
 * @Author chenzhuo
 * @Version 1.0
 * @Date 2019-06-03 21:58
 **/
public class SlefThreadPool {

    /**
     * 线程池线程数大小
     */
    private volatile int size;

    /**
     * 核心线程数
     */
    private int coreSize;


    /**
     * 默认初始化线程数
     */
    private final int initSize;

    /**
     * 最大线程数
     */
    private int mixSize;

    /**
     * 任务队列
     */
    private final BlockingQueue<Runnable> workQueue;

    /**
     * 锁
     */
    private final ReentrantLock mainLock = new ReentrantLock();

    /**
     *
     */
    private HashSet<Worker> workers = new HashSet<>();

    private AtomicLong threadNum = new AtomicLong();

    private ThreadFactory factory;

    public SlefThreadPool(int coreSize, int mixSize, BlockingQueue<Runnable> workQueue) {
        this.initSize = 1;
        this.coreSize = coreSize;
        this.mixSize = mixSize;
        this.workQueue = workQueue;
        this.factory = new ThreadFactoryImpl();
    }

    public void addThread(Runnable runnable) {
        if (null == runnable) {
            throw new NullPointerException();
        }

    }


    /**
     * 这里就保证初始化线程一直在跑就完了就
     */
    private void initThreadPool() {
        for (int i = 0; i < initSize; i++) {

        }
    }

    /**
     * 直接中断，不跟他多比比，
     * ThreadPoolExecutor 里还检测了这个线程是不是中断状态，
     * 然后再去尝试中断这里直接中断
     */
    public void shutdown() {
        for (Worker worker : workers) {
            worker.thread.interrupt();
        }
    }

    /**
     * 内部类 用来执行任务
     */
    public class Worker implements Runnable {
        final Thread thread;

        Runnable firstTask;

        public Worker(Runnable firstTask) {
            this.firstTask = firstTask;
            //使用当前的线程工厂来创建线程池
            this.thread = getFactory().newThread(this);
        }

        @Override
        public void run() {

        }
    }


    public int getSize() {
        return size;
    }

    ThreadFactory getFactory() {
        return factory;
    }

    public static class ThreadFactoryImpl implements ThreadFactory {

        private static final AtomicInteger poolNumber = new AtomicInteger(1);
        private final ThreadGroup group;
        private final AtomicInteger threadNumber = new AtomicInteger(1);
        private final String namePrefix;

        ThreadFactoryImpl() {
            SecurityManager s = System.getSecurityManager();
            group = (s != null) ? s.getThreadGroup() :
                    Thread.currentThread().getThreadGroup();
            namePrefix = "xp-" + poolNumber.getAndIncrement() + "-thread-";
        }

        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(group, r,
                    namePrefix + threadNumber.getAndIncrement(),
                    0);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            if (thread.getPriority() != Thread.NORM_PRIORITY) {
                thread.setPriority(Thread.NORM_PRIORITY);
            }
            return thread;
        }
    }

}

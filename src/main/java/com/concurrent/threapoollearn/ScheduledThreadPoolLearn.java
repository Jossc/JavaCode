package com.concurrent.threapoollearn;

import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName ScheduledThreadPoolLearn
 * @Author chenzhuo
 * @Version 1.0
 * @Date 2019-05-25 20:48
 **/
public class ScheduledThreadPoolLearn {

    final static ScheduledThreadPoolExecutor executor
            = new ScheduledThreadPoolExecutor(10);

    public static void main(String[] args) {
        ScheduledThreadPoolLearn sc = new ScheduledThreadPoolLearn();
        sc.scheduleAtFixedRate();
        executor.shutdown();;


    }

    /**
     * 延迟执行
     */
    private void schedule() {
        executor.schedule(() -> {
            new Rrun();
        }, 3, TimeUnit.SECONDS);
    }

    /**
     * 有延迟计划的，2秒
     */
    private void scheduleWithFixedDelay() {
        executor.scheduleWithFixedDelay(() -> {
            System.out.println("时间:" + System.currentTimeMillis());
        }, 1, 2, TimeUnit.SECONDS);
    }

    /**
     * 固定时间执行
     */
    private void scheduleAtFixedRate() {
        executor.scheduleAtFixedRate(() -> {
            System.out.println("时间:" + System.currentTimeMillis());
        }, 2, 2, TimeUnit.SECONDS);
    }

    private void shutdown() {
        executor.shutdown();
    }

    public class Rrun implements Callable {

        @Override
        public Object call() throws Exception {
            System.out.println("this is :" + System.currentTimeMillis());
            return null;
        }
    }
}

package com.basics.ThreadLocalTest;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * PACKAGENAME: com.basics.ThreadLocalTest
 * USER : chenzhuo
 * MONTH_NAME_SHORT: 七月
 * ThreadLocal 内存泄漏
 **/
public class ThreadLocalTestOne {
    /**
     * 内部类
     */
    static class  LocalVariable{
        private Long[] a = new Long[1024*1024];
    }
    //
    final static ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(5, 5, 1,
            TimeUnit.MINUTES,
            new LinkedBlockingQueue<>());

    final static ThreadLocal<LocalVariable>
            localVariable = new ThreadLocal<LocalVariable>();

    public static void main(String[] args) throws InterruptedException {
        // (3)
        for (int i = 0; i < 50; ++i) {
          /*  poolExecutor.execute(new Runnable() {
                public void run() {
                    // (4)
                    localVariable.set(new LocalVariable());
                    // (5)
                    System.out.println("use local varaible");
                    //localVariable.remove();

                }
            });
*/
            poolExecutor.execute(()->{
                localVariable.set(new LocalVariable());
                // (5)
                System.out.println("use local varaible");
                //localVariable.remove();
            });
            Thread.sleep(1000);
        }
        // (6)
        System.out.println("pool execute over");
    }

}

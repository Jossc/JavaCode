package com.basics.JavaassistTest;

import sun.misc.Contended;

/**
 * PACKAGENAME: com.basics.JavaassistTest
 * USER : chenzhuo
 * MONTH_NAME_SHORT: 八月
 * 执行环境：64位 windows，四核，16GB 内存
 *
 * 1.8 :已填充：32379924221/40012136161 毫秒
 * 1.8 :未填充：71927104917 毫秒
 *
 * 1.8 :添加Contended 13624380339
 *
 * 1.6:已填充：11225094222毫秒
 * 1.6:未填充：32909370119毫秒
 * -XX:-RestrictContended
 **/
public class FalshClineTest implements  Runnable{

    public static int NUM_THREADS = 4;
    public final static long ITERATIONS = 500L * 1000L * 1000L;
    private final int arrayIndex;
    private static VolatileLong[] longs;
    public static long SUM_TIME = 0l;

    public FalshClineTest(int arrayIndex) {
        this.arrayIndex = arrayIndex;
    }
    public static void main(final String[] args) throws Exception {
        Thread.sleep(10000);
        for(int j=0; j<10; j++){
            System.out.println(j);
            if (args.length == 1) {
                NUM_THREADS = Integer.parseInt(args[0]);
            }
            longs = new VolatileLong[NUM_THREADS];
            for (int i = 0; i < longs.length; i++) {
                longs[i] = new VolatileLong();
            }
            final long start = System.nanoTime();
            runTest();
            final long end = System.nanoTime();
            SUM_TIME += end - start;
        }
        System.out.println("平均耗时："+SUM_TIME/10);
    }

    /**
     * 线程组
     * @throws InterruptedException
     */
    private static void runTest() throws InterruptedException {
        Thread[] threads = new Thread[NUM_THREADS];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new FalshClineTest(i));
        }
        for (Thread t : threads) {
            t.start();
        }
        for (Thread t : threads) {
            t.join();
        }
    }
    public void run() {
        long i = ITERATIONS + 1;
        while (0 != --i) {
            longs[arrayIndex].value = i;
        }
    }

    /**
     * 测试伪装共享
     */
    @Contended
    public final static class VolatileLong {
        public volatile long value = 0L;
     //   public long p1, p2, p3, p4, p5, p6;//屏蔽此行
        //public volatile  long cvalue =1l;
    }
}

package com.basics.JucTest.LockFree;

import java.util.concurrent.CountDownLatch;

/**
 * @ClassName CountDownLatchTestAndJoin
 * @Description TODO
 * @Author chenzhuo
 * @Date 2018/9/20 10:43
 * @Version 1.0
 * see {@link java.util.concurrent.CountDownLatch}
 * CountDownLatch 只能使用一次，
 * countDownLatch.countDown()执行的时候减1
 * releases 传入的count值,
 * protected boolean tryReleaseShared(int releases) {
 *             // Decrement count; signal when transition to zero
 *             for (;;) {
 *                  //自旋获取state的值,就是new CountDownLatch(3)
 *                  //传入的值, 如果=0 直接返回false,不是的话就减1
 *                  //然后compareAndSetState cas计算比较
 *  *                 int c = getState();
 *                 if (c == 0)
 *                     return false;
 *                 int nextc = c-1;
 *                 if (compareAndSetState(c, nextc))
 *                     return nextc == 0;
 *             }
 *         }
 **/
public class CountDownLatchTestAndJoin {

    private static volatile CountDownLatch countDownLatch
            = new CountDownLatch(3);
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()->{
            try {
                Thread.sleep(1000);
                System.out.println("child threadOne over!");
                countDownLatch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread thread1 = new Thread(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            System.out.println("child threadTwo over!");
            countDownLatch.countDown();
        });
        thread.start();
        thread1.start();
        System.out.println("wait all child thread over!");
        // 等待子线程执行完毕，返回
        countDownLatch.await();
        System.out.println("all child thread over!");

    }



}

package com.basics.juctest.LockFree;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;

/**
 * PACKAGE_NAME: com.basics.juctest.LockFree
 * MONTH_NAME_SHORT: 十月
 * USER: Clement
 *
 **/
public class FariAdnUnfairTest {
    private  static  Lock fairLock
            = new ReentrantLockTest(true);
    private  static  Lock unFairLock
            = new ReentrantLockTest(false);
    public static CountDownLatch start;

    public void fair(){
        testLock(fairLock);
    }
    public void unfair(){
        testLock(unFairLock);
    }
    public void testLock(Lock lock){
        start = new CountDownLatch(1);
        for (int i = 0; i < 5; i++) {
            Thread thread = new Job(lock);
            thread.setName("" + i);
            thread.start();
        }
        start.countDown();
    }

    public static void main(String[] args) {
        FariAdnUnfairTest fariAdnUnfairTest
                = new FariAdnUnfairTest();
       /* fariAdnUnfairTest.fair();*/
        fariAdnUnfairTest.unfair();
    }

}

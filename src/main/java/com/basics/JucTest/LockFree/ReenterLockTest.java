package com.basics.JucTest.LockFree;

import java.util.concurrent.locks.ReentrantLock;

/**
 * PACKAGE_NAME: com.basics.JucTest.LockFree
 * MONTH_NAME_SHORT: 九月
 * USER: Clement
 **/
public class ReenterLockTest implements  Runnable{
    //ReentrantLock 可重入锁,使用aqs 中的state来维护状态，
    public static ReentrantLock reenterLockl = new ReentrantLock();

    public static int i = 0;
    @Override
    public void run() {
        for(int j=0;j<100000;j++){
            reenterLockl.lock();
          /*  reenterLockl.lock();*/
            try {
                i++;
            }finally {
                reenterLockl.unlock();
               /* reenterLockl.unlock();*/
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReenterLockTest reenterLockTest = new ReenterLockTest();
        Thread thread = new Thread(reenterLockTest);
        Thread thread1 = new Thread(reenterLockTest);
        thread.start();thread1.start();
        thread.join();thread1.join();
        System.out.println("i:" + i);
    }
    public void test(){

    }
}

package com.basics.JucTest.LockFree;

import java.util.concurrent.locks.Lock;

/**
 * PACKAGE_NAME: com.basics.JucTest.LockFree
 * MONTH_NAME_SHORT: 十月
 * USER: Clement
 **/
public class Job  extends  Thread{
    private Lock lock;
    public Job(Lock lock){
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            FariAdnUnfairTest.start.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            lock.lock();
            System.out.println("this thread :" + Thread.currentThread().getId());
            System.out.println("Lock by [" + getName() + "], Waiting by " + ((ReentrantLockTest) lock).getQueue());
        }finally {
            lock.unlock();
        }

    }

}

package com.basics.ThreadCode.ReentrantLockTest;

import java.util.concurrent.locks.ReentrantLock;

public class TReenTerLock implements  Runnable{

    public static ReentrantLock reentrantLock = new ReentrantLock();
    public static int i =0;
    @Override
    public void run() {
        for(int j=0;j<10000;j++){
            reentrantLock.lock();
            try {
                i++;
            }finally {
                reentrantLock.unlock();
            }
        }
    }


    public static void main(String []args) throws InterruptedException {
        TReenTerLock tReenTerLock = new TReenTerLock();
        Thread thread = new Thread(tReenTerLock);
        Thread thread1 = new Thread(tReenTerLock);
        thread.start();thread1.start();
        thread.join();thread1.join();
        System.err.println("i : " + i);
    }
}

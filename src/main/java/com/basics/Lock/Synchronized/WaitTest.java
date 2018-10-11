package com.basics.Lock.Synchronized;


import com.basics.ThreadCode.ThreadDemo.SleepUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * PACKAGE_NAME: com.basics.Lock.Synchronized
 * MONTH_NAME_SHORT: 十月
 * USER: Clement
 *
 *
 **/
public class WaitTest {
    static  boolean flag =true;
    static Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread waitThread = new Thread(new Wait(),"wait");
        waitThread.start();
        TimeUnit.SECONDS.sleep(1);
        Thread notifyThread = new Thread(new Notify(),"notifyAll");
        notifyThread.start();
    }

    static class Wait implements  Runnable{
        @Override
        public void run() {
            synchronized (lock){
                while (flag){
                    try {
                        System.out.println(Thread.currentThread()
                        +"flag is true" + new SimpleDateFormat("HH:mm:ss").
                                format(new Date()));
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println(Thread.currentThread()
                    +"flag is false" + new SimpleDateFormat("HH:mm:ss").
                    format(new Date()));
        }
    }
    static class Notify implements Runnable{

        @Override
        public void run() {
            synchronized (lock){
                System.out.println(Thread.currentThread()
                        +"hold lock " + new SimpleDateFormat("HH:mm:ss").
                        format(new Date()));
                lock.notifyAll();
                flag =false;
                SleepUtils.second(5);
            }

            synchronized (lock){
                System.out.println(Thread.currentThread()
                        +"hold lock again " + new SimpleDateFormat("HH:mm:ss").
                        format(new Date()));
                SleepUtils.second(5);
            }
        }
    }
}

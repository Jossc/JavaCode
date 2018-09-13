package com.basics.JucTest;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName ThreadSadeTest
 * @Description TODO
 * @Author chenzhuo
 * @Date 2018/9/10 21:50
 * @Version 1.0
 *
 *  Aqs 测试
 **/
public class ThreadSadeTest {


    public static void main(String[] args) {
       /* ReentrantLock reentrantLock = new ReentrantLock(false);
        *//**
         * tryLock
         * return sync.nonfairTryAcquire(1);
         *//*
        reentrantLock.tryLock();*/

        ReentrantLock reentrantLock
                = new ReentrantLock();
        Condition condition = reentrantLock.newCondition();
        Condition r = reentrantLock.newCondition();
        try {
            System.out.println("emmmm?");
            /**
             * Exception in thread "main" java.lang.IllegalMonitorStateException
             * 	at java.util.concurrent.locks.ReentrantLock$Sync.tryRelease(ReentrantLock.java:151)
             * 	at java.util.concurrent.locks.AbstractQueuedSynchronizer.release(AbstractQueuedSynchronizer.java:1261)
             * 	at java.util.concurrent.locks.AbstractQueuedSynchronizer.fullyRelease(AbstractQueuedSynchronizer.java:1723)
             * 	at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.await(AbstractQueuedSynchronizer.java:2036)
             * 	at com.basics.JucTest.ThreadSadeTest.main(ThreadSadeTest.java:31)
             */
         /*   condition.await();*/
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("emmmm~~~");
        }
        reentrantLock.lock();
        try {
            System.out.println("emmmm?");
            condition.await();
            /**
             *   Object o=new Object();
             *             o.wait();;
             *             o.notify();;
             *             同理
             */
            condition.signal();
            System.out.println("end wait");
            System.out.println("123123" );
        }catch (Exception e){

        }finally {
            reentrantLock.unlock();
        }

    }
}

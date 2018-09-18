package com.basics.JucTest.LockFree;

import java.util.concurrent.locks.AbstractQueuedLongSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * PACKAGE_NAME: com.basics.JucTest.LockFree
 * MONTH_NAME_SHORT: 九月
 * USER: Clement
 * Condition
 * See {@link AbstractQueuedLongSynchronizer}
 * {@link Condition}
 *
 * 生产和消费
 **/
public class ReenterCondition {
    private String name;
    private int count= 1;
    private  boolean flag =false;


    Lock lock = new ReentrantLock();
    Condition producer = lock.newCondition();
    Condition counsumer = lock.newCondition();


    /**
     * 生产----
     * @param name
     */
    public void producer(String name){
        lock.lock();
        try {
            while (flag){
                //如果没有就等待
                producer.await();
            }
            this.name = name+count;
            count++;
            System.out.println("ThreadName : "+
            Thread.currentThread().getName()+"产出 : "+this.name);
            flag = true;
            //直接唤醒消费线程
            counsumer.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    /**
     * 消费啊
     *
     */
    public void counsumer(){
        lock.lock();
        try {
            while (!flag){
                try {
                    counsumer.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            ////消费一个
            System.out.println(Thread.currentThread().getName()+"消费 :"+this.name);
            flag = false;
            producer.signal();
        }finally {
            lock.unlock();
        }
    }

}

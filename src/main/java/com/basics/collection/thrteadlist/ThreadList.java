package com.basics.collection.thrteadlist;

import org.junit.runner.notification.RunListener;

import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * @ClassName ThreadList
 * @Description TODO
 * @Author chenzhuo
 * @Date 2018/10/28 21:17
 * @Version 1.0
 * 线程安全的
 **/
@RunListener.ThreadSafe
public class ThreadList<T> {

    private final List<T> list;

    public ThreadList(List<T> list) {
        this.list = list;
    }

    /**
     * 如果为空就添加
     * @param x
     * @return
     */
    public synchronized  boolean putIfAbsent(T x){
        boolean count = list.contains(x);
        if(count){
            list.add(x);
        }
        return !count;
    }
    public boolean putAbsent(T objec){
        Lock lock = new ReentrantLock();
        lock.lock();
        try {
            boolean count = list.contains(objec);
            if(count){
                list.add(objec);
            }
            return !count;
        }finally {
            lock.unlock();
        }
    }
}

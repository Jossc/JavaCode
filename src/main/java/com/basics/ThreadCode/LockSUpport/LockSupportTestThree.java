package com.basics.ThreadCode.LockSUpport;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.LockSupport;

/**
 * @ClassName LockSupportTestThree
 * @Description TODO
 * @Author chenzhuo
 * @Date 2018/8/15 16:28
 * @Version 1.0
 * 总结
 **/
public class LockSupportTestThree {
    private final AtomicBoolean locked = new AtomicBoolean(false);
    private final Queue<Thread> waiters = new ConcurrentLinkedQueue<Thread>();

    public void lock() {
        boolean wasInterrupted = false;
        Thread current = Thread.currentThread();
        waiters.add(current);
        // 只有队首的线程可以获取锁（1）
        while (waiters.peek() != current || !locked.compareAndSet(false, true)) {
            LockSupport.park(this);
            if (Thread.interrupted()) // （2）
                wasInterrupted = true;
        }
        waiters.remove();
        if (wasInterrupted) // （3）
            current.interrupt();
    }

    public void unlock() {
        locked.set(false);
        LockSupport.unpark(waiters.peek());
    }
}

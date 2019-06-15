package com.basics.lock.aqs;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * 自定义锁
 *
 * @ClassName CustomizeLock
 * @Author chenzhuo
 * @Version 1.0
 * @Date 2019-05-04 12:24
 **/
public class CustomizeLock implements Lock {
    private final Sync sync;

    /**
     * 基类
     */
    abstract static class Sync extends AbstractQueuedSynchronizer {

        /**
         * 加锁
         */
        abstract void lock();

        /**
         * 判断当前线程是不是同一个线程
         *
         * @return
         */
        @Override
        protected boolean isHeldExclusively() {
            return Thread.currentThread() == getExclusiveOwnerThread();
        }

        @Override
        protected int tryAcquireShared(int arg) {
            return super.tryAcquireShared(arg);
        }


        /**
         * 释放锁 其实调用了 tryRelease
         * AbstractQueuedSynchronizer 中有node节点
         *
         * @param arg
         * @return
         */
        public  boolean unLock(int arg) {
            return tryRelease(arg);
        }

        /**
         * 尝试释放锁
         *
         * @param arg
         * @return
         */
        @Override
        protected boolean tryRelease(int arg) {
            int state = getState() - arg;
            if (Thread.currentThread() != getExclusiveOwnerThread()) {
                throw new RuntimeException();
            }
            boolean free = false;
            //如果等于0就代表释放锁
            if (state == 0) {
                free = true;
                //持有锁的线程为null
                setExclusiveOwnerThread(null);
            }
            //谁知新的值
            setState(state);
            return free;
        }

        /**
         * 尝试枷锁
         *
         * @param acquires
         * @return
         */
        final boolean nonfairTryAcquire(int acquires) {
            final Thread current = Thread.currentThread();
            int c = getState();

            /**
             * 如果c是0的情况
             */
            if (c == 0) {
                if (compareAndSetState(0, acquires)) {
                    //设置当前线程拥有所
                    setExclusiveOwnerThread(current);
                    return true;
                }
            }
            //如果当前线程和拥有锁的线程是一个线程 代表当前这个线程冲入
            if (current == getExclusiveOwnerThread()) {
                int nextc = c + acquires;
                if (nextc < 0) {
                    throw new Error("Maximum lock count exceeded");
                }
                setState(nextc);
                return true;
            }
            return false;
        }

        /**
         * 规定时间内获取锁
         *
         * @param time
         * @param unit
         * @return
         */
        public abstract boolean tryAcquireNanos(long time, TimeUnit unit);
    }

    /**
     * 公平锁
     */
    class FairSync extends Sync {

        @Override
        void lock() {
            acquire(1);
        }

        @Override
        public boolean tryAcquireNanos(long time, TimeUnit unit) {
            return sync.tryAcquireNanos(time, unit);
        }
    }

    /**
     * 非公平锁
     */
    class NoFairSync extends Sync {

        @Override
        void lock() {
            //所有的线程直接去更新值，谁更新成功了谁获取
            if (compareAndSetState(0, 1)) {
                setExclusiveOwnerThread(Thread.currentThread());
            } else {
                acquire(1);
            }
        }

        @Override
        public boolean tryAcquireNanos(long time, TimeUnit unit) {
            return sync.tryAcquireNanos(time, unit);
        }
    }

    public CustomizeLock() {
        sync = new FairSync();
    }

    public CustomizeLock(Sync sync) {
        this.sync = sync;
    }

    /**
     * 锁
     */
    @Override
    public void lock() {
        sync.lock();
    }

    /**
     * 判断当前线程是否可用状态
     *
     * @throws InterruptedException
     */
    @Override
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }


    /**
     * 尝试锁
     *
     * @return
     */
    @Override
    public boolean tryLock() {
        return sync.nonfairTryAcquire(1);
    }

    /**
     * 尝试锁 带超时
     *
     * @param time
     * @param unit
     * @return
     * @throws InterruptedException
     */
    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireNanos(time, unit);
    }

    /**
     * 释放锁
     */
    @Override
    public void unlock() {
        sync.release(1);
    }

    /**
     * 创建条件节点
     *
     * @return Condition
     */
    @Override
    public Condition newCondition() {
        return sync.new ConditionObject();
    }
}

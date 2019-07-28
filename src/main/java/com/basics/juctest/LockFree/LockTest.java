package com.basics.juctest.LockFree;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedLongSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * PACKAGE_NAME: com.basics.juctest.LockFree
 * MONTH_NAME_SHORT: 十月
 * USER: Clement
 * 不是可冲入锁
 *
 **/
public class LockTest implements Lock {
    private  static  class Sync extends AbstractQueuedLongSynchronizer{
        @Override
        /**
         * 判断是不是占用的状态
         */
        protected boolean isHeldExclusively() {
            return getState()==1;
        }
        public boolean tryAcquire(int acquires){
            if(compareAndSetState(0,1)){
                setExclusiveOwnerThread(Thread.currentThread());
                return  true;
            }
            return  false;
        }

        @Override
        protected boolean tryRelease(long arg) {
            if(getState()==0){
                throw  new IllegalMonitorStateException();
            }
            setExclusiveOwnerThread(null);
            setState(0);
            return   true;
        }
        Condition newCodition(){
            return  new ConditionObject();
        }
    }
    private  final Sync sync = new Sync();
    @Override
    public void lock() {
        sync.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireNanos(1,unit.toNanos(time));
    }

    @Override
    public void unlock() {
        sync.release(1);
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}

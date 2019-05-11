package com.basics.Lock.Synchronized;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName: LockFreeTest
 * @Description TODO
 * @Date 2019/1/24 14:19
 * @Created by chenzhuo
 **/
public class LockFreeTest {
    private static Lock lock = new ReentrantLock(true);

    /**
     * stack=1, locals=1, args_size=1
     * 0: getstatic     #2                  // Field lock:Ljava/util/concurrent/locks/Lock;
     * 3: invokeinterface #3,  1            // InterfaceMethod java/util/concurrent/locks/Lock.lock:()V
     * 8: invokestatic  #4                  // Method test:()V
     * 11: getstatic     #2                  // Field lock:Ljava/util/concurrent/locks/Lock;
     * 14: invokeinterface #5,  1            // InterfaceMethod java/util/concurrent/locks/Lock.unlock:()V
     * 19: return
     *
     * @param args
     */
    public static void main(String[] args) {
        lock.lock();
        test();
        lock.unlock();

    }

    public static void test() {
        System.out.println("lock free Test");
    }
}

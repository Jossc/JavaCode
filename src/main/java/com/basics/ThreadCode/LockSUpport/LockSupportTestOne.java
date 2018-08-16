package com.basics.ThreadCode.LockSUpport;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.locks.LockSupport;

/**
 * @ClassName LockSupportTestOne
 * @Description TODO
 * @Author chenzhuo
 * @Date 2018/8/14 9:48
 * @Version 1.0
 * 屠龙之技
 **/
public class LockSupportTestOne {
    static Unsafe unsafe;
    static {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe = (Unsafe) field.get(null);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void main(String []args){
        System.out.println("start -------------");
    /*    unsafe.park(true,10000000000L);
        unsafe.unpark(Thread.currentThread());*/
        LockSupport.parkNanos(1000L);
        LockSupport.unpark(Thread.currentThread());
        System.out.println("end -------------");
        LockSupportTestOne lockSupportTestOne
                = new LockSupportTestOne();
        try {
            lockSupportTestOne.runStart();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void runStart() throws InterruptedException {
        Thread thread = new Thread(()->{
            System.out.println("child thread begin park!");
            /**
             * 如果线程不被中断就被挂起
             */
            while (!Thread.currentThread().isInterrupted()){
                LockSupport.park();
            }
        });
        thread.start();
        Thread.sleep(1000);
        System.out.println("main thread begin unpark!");
        //thread.interrupt();
        //这里不中断的话 肯定会一直挂起
        LockSupport.unpark(thread);
    }

}

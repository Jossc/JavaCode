package com.basics.ThreadCode.LockSUpport;

import java.util.concurrent.locks.LockSupport;

/**
 * PACKAGE_NAME: com.basics.ThreadCode.LockSUpport
 * MONTH_NAME_SHORT: 四月
 * USER: Clement
 **/
public class LockSupportTestThread {

    public static void main(String []args) throws InterruptedException {
        Thread thread =
                new Thread(()->{
                    System.err.println("child thread begin park");
                    //自己挂自己
                    LockSupport.park();
                    System.out.println("child thread unpark!");
                });
        thread.start();
        Thread.sleep(1000);
        System.err.println("main thread begin un park");
        LockSupport.unpark(thread);
    }
}

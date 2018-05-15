package com.basics.ThreadCode;

/**
 * PACKAGE_NAME: com.basics.ThreadCode
 * MONTH_NAME_SHORT: 五月
 * USER: Clement
 * 线程调用共享对象的 wait()
 * 方法被阻塞挂起后，如果其它线程中断了该线程，
 * 则该线程会抛出 InterruptedException
 **/
public class WaitNotifyInterupt {
    static  Object object = new Object();

    public static void main(String [] args) throws InterruptedException {
        Thread threadA = new Thread(()->{
            try {
                System.err.println("---begin---");
                //阻塞线程
                object.wait();
                System.out.println("---end---");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        threadA.start();
        Thread.sleep(1000);
        System.err.println("---begin interrupt threadA---");
        threadA.interrupt();
        System.out.println("---end interrupt threadA---");
        threadA.wait(1);
        threadA.wait(1,1);

    }
}

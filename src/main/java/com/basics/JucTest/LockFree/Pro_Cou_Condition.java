package com.basics.JucTest.LockFree;

/**
 * PACKAGE_NAME: com.basics.JucTest.LockFree
 * MONTH_NAME_SHORT: 九月
 * USER: Clement
 * 主方法
 **/
public class Pro_Cou_Condition {
    public static void main(String[] args) {
        ReenterCondition
                reenterCondition = new ReenterCondition();
        ProducerThread thread  = new ProducerThread(reenterCondition);
        ConsumerThread consumerThread
                = new ConsumerThread(reenterCondition);
        Thread thread1 = new Thread(thread);
        Thread thread2 = new Thread(thread);

        Thread thread3 = new Thread(consumerThread);
        Thread thread4 = new Thread(consumerThread);

        thread1.start();
        thread2.start();

        thread3.start();
        thread4.start();
    }
}

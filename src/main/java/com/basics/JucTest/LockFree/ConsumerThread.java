package com.basics.JucTest.LockFree;

/**
 * PACKAGE_NAME: com.basics.JucTest.LockFree
 * MONTH_NAME_SHORT: 九月
 * USER: Clement
 **/
public class ConsumerThread implements Runnable {
    private ReenterCondition reenterCondition;

    public ConsumerThread(ReenterCondition reenterCondition){
        this.reenterCondition = reenterCondition;
    }
    @Override
    public void run() {
        while (true){
            reenterCondition.counsumer();
        }
    }
}

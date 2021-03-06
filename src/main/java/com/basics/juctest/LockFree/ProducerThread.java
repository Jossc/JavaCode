package com.basics.juctest.LockFree;

/**
 * PACKAGE_NAME: com.basics.juctest.LockFree
 * MONTH_NAME_SHORT: 九月
 * USER: Clement
 * 生产线程
 **/
public class ProducerThread implements  Runnable{
    private  ReenterCondition reenterCondition;

    public ProducerThread(ReenterCondition reenterCondition){
        this.reenterCondition= reenterCondition;
    }

    @Override
    public void run() {
        while (true){
            reenterCondition.producer("生产~~~~~");
        }
    }
}

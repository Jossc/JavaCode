package com.basics.JucTest.atomic;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;

/**
 * PACKAGE_NAME: com.basics.JucTest.atomic
 * MONTH_NAME_SHORT: 十月
 * USER: Clement
 **/
public class TestAtomic {
    private volatile long  so_laong = 10;
    private  static  AtomicLongFieldUpdater atomicLongFieldUpdater
             = AtomicLongFieldUpdater.newUpdater(TestAtomic.class,"so_laong");
    public static void main(String[] args) {

        /*AtomicLong
                atomicLong = new AtomicLong(0);
        atomicLong.set(10);

        atomicLong.compareAndSet(10,100);


        AtomicLong atomicLong1 = new AtomicLong();
        atomicLong1.set(100);
        atomicLong.updateAndGet(a->1000L);
        atomicLong.getAndUpdate(a->200l);
        System.out.println("atomicLong : " + atomicLong.get());*/
        TestAtomic testAtomic = new TestAtomic();
        long getLong = atomicLongFieldUpdater.get(testAtomic);
        System.out.println("long : " + getLong);

    }
}

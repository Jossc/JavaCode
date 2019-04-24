package com.basics.atomiclongtest;

import java.util.concurrent.atomic.AtomicLong;

/**
 * PACKAGE_NAME: com.basics.atomiclongtest
 * MONTH_NAME_SHORT: 四月
 * USER: Clement
 **/
public class AtomicLongTest {
    private static AtomicLong
     atomicLong = new AtomicLong();

    private static  Integer[] one
             = new Integer[]{0,1,2,3,0,5,6,0,56,0};
    private static Integer[] two
            = new Integer[]{10,1,2,3,0,5,6,0,56,0};


    public static void main(String []args) throws InterruptedException {
        Thread oneThread = new Thread(()->{
            int size = one.length;
            for(int i =0;i<size;i++){
                if(one[i].intValue() == 0){
                    atomicLong.incrementAndGet();
                }
            }
        });
        Thread twoThread = new Thread(()->{
            int size = two.length;
            for(int i =0;  i<size;i++){
                if(two[i].intValue() == 0){
                    atomicLong.set(1);
                }
            }
        });
        oneThread.start();
        twoThread.start();

        oneThread.join();
        twoThread.join();

        System.err.println("basicsThread : " + atomicLong.get());

    }
}

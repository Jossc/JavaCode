package com.basics.TestIterator;


import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * PACKAGE_NAME: com.basics.TestIterator
 * MONTH_NAME_SHORT: 五月
 * USER: Clement
 * java 种弱一致性
 **/
public class TestIterator {
    public static ConcurrentLinkedQueue<String>
        concurrentLinkedQueue = new ConcurrentLinkedQueue<>();

    public static void main(String []args){
        concurrentLinkedQueue.offer("zlx");
        concurrentLinkedQueue.offer("gh");
        concurrentLinkedQueue.offer("hello");

        SleepInterrupt sleepInterrupt = new SleepInterrupt();
        sleepInterrupt.start();
        Iterator<String>
                iterable = concurrentLinkedQueue.iterator();
        while (iterable.hasNext()){
            iterable.remove();
            System.err.println("next:" + iterable.next());
        }
    }

    public  static class SleepInterrupt extends  Thread{
       /* public void run(){
            try{
                System.err.println(
                        concurrentLinkedQueue.remove("zlx")
                );
            }catch (Exception e){
                return;
            }
        }*/
    }
}

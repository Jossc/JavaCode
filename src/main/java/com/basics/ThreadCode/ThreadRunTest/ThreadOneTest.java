package com.basics.ThreadCode.ThreadRunTest;

/**
 * PACKAGENAME: com.basics.ThreadCode.ThreadRunTest
 * USER : chenzhuo
 * MONTH_NAME_SHORT: 七月
 *
 * @simg Synchronized
 **/
public class ThreadOneTest {
    public static void main(String []args){
        ThreadOneTest threadOneTest = new ThreadOneTest();
        synchronized(threadOneTest){
            threadOneTest.count();
        }
    }
    public  void count(){
        int i =0;
        i++;
        System.out.println("i: ====  " + i);
    }
}

package com.sun.proxy;

/**
 * @ClassName ThreadRun
 * @Description TODO
 * @Author chenzhuo
 * @Date 2018/9/14 17:37
 * @Version 1.0
 **/
public class ThreadRun {

    public  synchronized  static void testSy() {
        int i = 5;
        while( i-- > 0) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
        }
    }
}

package com.concurrent.thread.volatileone;

/**
 * @ClassName VolatileTwo
 * @Author chenzhuo
 * @Version 1.0
 * @Date 2019-07-13 22:56
 **/
public class VolatileTwo {
    private int first;


    private volatile int two;


    public static void main(String[] args) {


    }


    public void write() {
        first = 1;
        two = 2;
    }

    public void read() {
        int i = first;
        int j = two;

    }
}

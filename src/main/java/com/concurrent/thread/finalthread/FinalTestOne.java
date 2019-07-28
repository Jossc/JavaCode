package com.concurrent.thread.finalthread;

import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName FinalTestOne
 * @Author chenzhuo
 * @Version 1.0
 * @Date 2019-07-21 20:30
 **/
@Slf4j
public class FinalTestOne {

    int i;

    final int j;

    static FinalTestOne testOne;

    FinalTestOne() {
        this.i = 1;
        this.j = 2;
    }

    static void writer() {
        testOne = new FinalTestOne();
    }

    public static void reader() {
        FinalTestOne object = testOne;
        int a = object.i;
        int b = object.j;
        System.out.println(a);
        System.out.println(b);
    }

    public static void main(String[] args) {

        Thread reader = new Thread(() -> {
            reader();
        });
        Thread thread = new Thread(() -> {
            writer();
        });
        thread.start();
        reader.start();
    }
}

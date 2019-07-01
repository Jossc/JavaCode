package com.concurrent.threapoollearn;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName ThreadPoolLearn
 * @Author chenzhuo
 * @Version 1.0
 * @Date 2019-05-19 21:06
 **/
public class ThreadPoolLearn {

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 2, 2,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(1), new ThreadPoolTest.DemonFactory());

        threadPoolExecutor.execute(()->{
            System.out.println("hello word");
        });
    }

    public void executeToTest(int i ,boolean tag) {
    }
}

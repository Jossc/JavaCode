package com.sun;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName ThreadTest
 * @Description TODO
 * @Author chenzhuo
 * @Date 2018/9/14 17:32
 * @Version 1.0
 **/
public class ThreadTest implements Runnable  {



    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(8);
        executorService.submit(new ThreadTest());
    }

    @Override
    public void run() {
        ThreadRun.testSy();
    }
}

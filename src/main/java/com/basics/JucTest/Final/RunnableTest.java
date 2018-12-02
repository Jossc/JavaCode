package com.basics.JucTest.Final;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @ClassName RunnableTest
 * @Description TODO
 * @Author chenzhuo
 * @Date 2018/10/1 19:46
 * @Version 1.0
 **/
public class RunnableTest {

    public static void main(String[] args) {
        ExecutorService executorService
                = Executors.newFixedThreadPool(10);
        for(int i= 0;i<11;i++){
            Future<?> submit = executorService.submit(() -> {
           /*    FinalTest.wirte();
               FinalTest.read();*/
                FinalTestForReference.wirte();
                FinalTestForReference.read();
            });
        }


        executorService.shutdown();
    }
}

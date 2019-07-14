package com.basics.ThreadCode.CountDownLatchTest;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CountDownLatch
 */
public class TestCountDownLatch {
    private static  final  int ThreadNum = 10;
    public static void  main(String []args){
        CountDownLatch downLatch
                = new CountDownLatch( ThreadNum);
        ExecutorService executorService
                = Executors.newFixedThreadPool(ThreadNum);

        for(int i =0;i<ThreadNum;i++){
            executorService.execute(new Person(downLatch, i+1));
        }
        System.err.println("emmmmmm...");

        try {
            downLatch.await();
            System.err.println("objk");
           // executorService.shutdownNow();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally { executorService.shutdownNow();
        }
    }
    static class Person implements Runnable{

        private CountDownLatch countDownLatch;
        private int index;

        public Person(CountDownLatch cdl,int index){
            this.countDownLatch = cdl;
            this.index = index;
        }

        @Override
        public void run() {

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("person " + index +"签到");

            //线程执行完毕，计数器减一
            countDownLatch.countDown();

        }

    }
}

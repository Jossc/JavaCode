package com.basics.JucTest.CallableTest;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @ClassName CallableMain
 * @Description TODO
 * @Author chenzhuo
 * @Date 2018/11/1 22:04
 * @Version 1.0
 **/
public class CallableMain {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CallableDemon callableDemon
                = new CallableDemon();
        FutureTask<Integer>
                futureTask = new FutureTask<>(callableDemon);
      /*  futureTask.run();*/
        new Thread(()->{
            try {
                //get 等待中断或超时完成或中止。
                System.out.println("integer :" +
                    futureTask.get());
            } catch (InterruptedException e) {
               Thread.currentThread().isInterrupted();
               //设置任务无效
               futureTask.cancel(true);
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

        }).start();
        new Thread(futureTask).start();
        System.out.println("开始执行。。。。。。");
        System.out.println("get :" + futureTask.get());
    }
}

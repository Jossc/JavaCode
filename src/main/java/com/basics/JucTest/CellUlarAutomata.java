package com.basics.JucTest;

import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

/**
 * @ClassName CellUlarAutomata
 * @Description TODO
 * @Author chenzhuo
 * @Date 2018/10/31 21:47
 * @Version 1.0
 **/
public class CellUlarAutomata {
/*    private final CyclicBarrier cyclicBarrier ;

    public   CellUlarAutomata(CyclicBarrier cyclicBarrier){
        this.cyclicBarrier = cyclicBarrier;
    }*/
    public void start() throws BrokenBarrierException, InterruptedException {
        CyclicBarrier cyclicBarrier
                 = new CyclicBarrier(10,()->{
                     for(int i =0;i<100;i++){
                         System.out.println("i:" + i);
                     }
        });
       int i =  cyclicBarrier.getParties();
       System.out.println("i  ：" +i );
      /*  CellUlarAutomata
        cyclicBarrier.await();
        cyclicBarrier.getParties();*/
    }

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        CellUlarAutomata cellUlarAutomata
                = new CellUlarAutomata();
        cellUlarAutomata.start();
        ConcurrentHashMap map = new ConcurrentHashMap();
     /*   map.putIfAbsent()*/

        ExecutorService executor = Executors.newFixedThreadPool(100);

        executor.submit(()->{
            for(int i =0 ;i<100;i++){
                System.out.println("hello word");
                /*try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
            }
        });

        executor.shutdown();
        boolean b = executor.awaitTermination(1,TimeUnit.SECONDS);
        System.out.println("b : " + b);
        if(b){
            List<Runnable> runnables = executor.shutdownNow();
            executor.isTerminated();
            runnables.forEach(runnable -> System.out.println("Thread id:" + runnable));

        }

    }
}

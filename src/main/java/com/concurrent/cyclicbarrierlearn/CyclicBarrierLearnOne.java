package com.concurrent.cyclicbarrierlearn;

import java.util.concurrent.CyclicBarrier;

/**
 * @ClassName CyclicBarrierLearnOne
 * @Despacito TODO
 * @Author chenzhuo
 * @Version 1.0
 **/
public class CyclicBarrierLearnOne {

    private  static CyclicBarrier barrier;

    public static void main(String[] args) {
        barrier = new CyclicBarrier(3, () -> System.out.println("开始~~~"));
        for(int i =0;i<3;i++){
            new CyRun().start();
        }
    }

    public static class CyRun extends  Thread{

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "到了");
            try {
                barrier.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}

package com.basics.ThreadPool;

import sun.nio.ch.ThreadPool;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.DoubleStream;

/**
 * PACKAGENAME: com.basics.ThreadPool
 * USER : chenzhuo
 * MONTH_NAME_SHORT: 七月
 * ThreadLocalRandom 测试
 **/
public class ThreadPoolOne {

    public static void main(String []args){

   /*     ThreadPool threadPool = new ThreadPool();*/
        ThreadLocalRandom threadLocalRandom =ThreadLocalRandom.current() ;
        DoubleStream doubles = threadLocalRandom.doubles();
        for(int i=0;i<10;i++){
            System.out.println("随机数"+  threadLocalRandom.nextInt(100));
        }
    }
    public void wirte(){

    }
}

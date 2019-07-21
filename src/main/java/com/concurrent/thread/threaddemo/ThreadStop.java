package com.concurrent.thread.threaddemo;

/**
 * @ClassName ThreadStop
 * @Author chenzhuo
 * @Version 1.0
 * @Date 2019-07-20 23:49
 * 线程停止
 **/
public class ThreadStop {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new ThreadStopClass(),"ThreadStopClass");
        thread.start();
        thread.stop();
    }

}
class ThreadStopClass implements  Runnable{

    @Override
    public void run() {
        System.out.println("this  is  ThreadStopClass");
    }
}
package com.basics.ThreadCode.ThreadDemo;

/**
 * @ClassName ThreadState
 * @Description TODO
 * @Author chenzhuo
 * @Date 2018/10/9 15:40
 * @Version 1.0
 **/
public class ThreadState {
    public static void main(String[] args) {
        new Thread(new TimeWaiting(),"TimeWaitingThread").start();
        new Thread(new Waitting(),"Waitting").start();
        new Thread(new Block(), "BlockedThread-1").start();
        new Thread(new Block(), "BlockedThread-2").start();
        Thread.interrupted();

    }

}

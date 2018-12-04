package com.sun.jvm.Jvm;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName OnStackTest
 * @Despacito TODO
 * @Author chenzhuo
 * @Version 1.0
 * -server -Xmx10m -Xms10m -XX:+DoEscapeAnalysis -XX:+PrintGC -XX:-UseTLAB
 * -XX:+EliminateAllocations
 * <p>
 * 启用server
 * xmx 最大堆空间
 * xms
 * -XX:+EliminateAllocations 开启了标量替换（默认打开）
 * -XX:+DoEscapeAnalysis 启用逃逸分析
 * -Xx::+PrintGC 打印GC日志
 **/
public class OnStackTest {
    public static class User {
        public int id = 0;
        public String name = "";
    }

    public static void alloc() {
        Lock lock = new ReentrantLock();
        lock.lock();
        User user = new User();
        //4个字节
        user.id = 5;
        //6个字节 说明是 GBK
        user.name = "陈卓";
        lock.unlock();
    }

    public static void main(String[] args) {
        long b = System.currentTimeMillis();
        //循环1e次 就算需要1.2g的空间
        //-server -Xmx10m -Xms10m -XX:+DoEscapeAnalysis -XX:+PrintGC -XX:-UseTLAB
        //没有gc说明 创建对象逃逸
        //
        for (int i = 0; i < 100000000; i++) {
            alloc();
        }
     /*   String s = new String("陈卓");
        System.out.println("s.length:"+s.getBytes().length);*/
        long e = System.currentTimeMillis();
        System.out.println("时间：" + (e - b));
    }

}

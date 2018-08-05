package com.basics.ThreadCode.ThreadLocalDemo;

/**
 * @PACKAGE_NAME: com.basics.ThreadCode.ThreadLocalDemo
 * @PROJECT_NAME: JavaCode
 * @Date: 2018/4/11
 * @author: chenzhuo
 * 本地线程变量
 * 内部 ThreadLocalMap
 */
public class ThreadLocalTest {
    static  ThreadLocal<String> stringThreadLocal = new ThreadLocal<>();
    static void print(String str){
        System.out.println(str + ": " + stringThreadLocal.get());
    }

    public static  void main(String []args){
        Thread thread = new Thread(()->{
            stringThreadLocal.set("thread on threadLocal one");
            print("threadOne");
            System.out.println("threadOne " + stringThreadLocal.get());
        });

        Thread thread1 = new Thread(()->{
            stringThreadLocal.set("thread on threadLocal two");
            print("threadTwo");
            System.out.println("threadTwo " + ":" +stringThreadLocal.get());
        });

        thread.start();
        thread1.start();
    }


}

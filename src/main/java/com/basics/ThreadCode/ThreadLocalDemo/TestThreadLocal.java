package com.basics.ThreadCode.ThreadLocalDemo;

/**
 * @PACKAGE_NAME: com.basics.ThreadCode.ThreadLocalDemo
 * @PROJECT_NAME: JavaCode
 * @Date: 2018/4/12
 * @author: chenzhuo
 * 子线程获取父线程中的值
 * 获取不到
 * InheritableThreadLocal
 */
public class TestThreadLocal {
    public static ThreadLocal<String>
            threadLocal = new ThreadLocal<>();

    public static void main(String []args){
        threadLocal.set("hello word");
        Thread thread =  new Thread(()->{
            System.out.println("thread :" +
                threadLocal.get());
        });
        thread.start();
        System.out.println("main:" + threadLocal.get());
    }

}

package com.basics.ThreadCode.ThreadLocalDemo;

/**
 * @PACKAGE_NAME: com.basics.ThreadCode.ThreadLocalDemo
 * @PROJECT_NAME: JavaCode
 * @Date: 2018/4/12
 * @author: chenzhuo
 *
 * InheritableThreadLocal
 * 直接创建父线程的变量
 */
public class InheritableThreadLocalTest {

    public static ThreadLocal<String>
            threadLocal = new InheritableThreadLocal<>();

    public static void main(String []args){
        threadLocal.set("hello word");
        Thread thread =  new Thread(()->{
            System.out.println("thread :" +
                    threadLocal.get());
        });
       /* threadLocal.set();*/
        thread.start();
        System.out.println("main:" + threadLocal.get());
    }

}

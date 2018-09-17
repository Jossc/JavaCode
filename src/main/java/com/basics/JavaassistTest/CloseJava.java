package com.basics.JavaassistTest;

/**
 * @ClassName CloseJava
 * @Description TODO
 * @Author chenzhuo
 * @Date 2018/8/17 17:01
 * @Version 1.0
 **/
public class CloseJava {
    public static void main(String[] args) {
        Thread thread = new Thread(()->{
            System.out.println("emmmmmmmmmmmmmm----------");
        });
        thread.setName("测试内存钩子");
        thread.start();
        stopForJava(thread);
    }
    public static void stopForJava(Thread thread){
        System.out.println("name : " +thread.getName());
        Runtime.getRuntime().addShutdownHook(thread);
    }
}

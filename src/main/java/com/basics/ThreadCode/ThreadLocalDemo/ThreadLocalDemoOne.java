package com.basics.ThreadCode.ThreadLocalDemo;

/**
 * PACKAGENAME: com.basics.ThreadCode.ThreadLocalDemo
 * USER : chenzhuo
 * MONTH_NAME_SHORT: 七月
 * 最近有时间了 可以写自己的东西了，
 * 无聊就看一下javaP
 *
 *
 **/
public class ThreadLocalDemoOne {
    public static  ThreadLocal<Object>
        threadLocal = ThreadLocal.withInitial(()->{
            return  new Object();
    });


    /**
     * final语意
     */
    public final static String string="final语意";



    /**
     * 主程序入口
     * @param args
     */
    public static  void main(String []args){

        System.out.println(":----- " + getString() );
        threadLocal.set("测试一下啊");
        System.out.print("-------em? : " + threadLocal.get());
    }

    private static  String getString(){
        return string;
    }

}

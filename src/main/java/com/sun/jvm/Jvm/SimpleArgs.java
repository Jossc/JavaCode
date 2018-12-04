package com.sun.jvm.Jvm;

/**
 * @ClassName SimpleArgs
 * @Despacito TODO
 * @Author chenzhuo
 * @Version 1.0
 * 基本参数学习
 * -Xmx:3799M
 *
 **/
public class SimpleArgs {
    public static void main(String[] args) {
        for (int i=0;i<args.length;i++){
            System.out.println("参数："+(i+i) +":" +args[i]);
        }
        System.out.println("-Xmx:" + Runtime.getRuntime().maxMemory()/1000/1000 +"M");
    }
}

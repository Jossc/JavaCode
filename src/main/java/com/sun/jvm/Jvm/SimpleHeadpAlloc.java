package com.sun.jvm.Jvm;

/**
 * @ClassName SimpleHeadpAlloc
 * @Despacito TODO
 * @Author chenzhuo
 * @Version 1.0
 * -Xmx20m -Xms5m -XX:+PrintCommandLineFlags -XX:+PrintGCDetails -XX:+UseSerialGC
 **/
public class SimpleHeadpAlloc {
    public static void main(String[] args) {
        getOut();
        byte[] b = new byte[1*1024*1024];
        System.out.println("分配了1m空间给数组");
        getOut();
        b = new byte[4*1024*1024];
        System.out.println("分配了4m空间给数组");
        getOut();
    }

    private static void getOut() {
        System.out.println("maxMemory==");
        System.out.println(Runtime.getRuntime().maxMemory() + "bytes");
        System.out.println("free mem = ");
        System.out.println(Runtime.getRuntime().freeMemory() + "bytes");
        System.out.println("total mem=");
        System.out.println(Runtime.getRuntime().totalMemory());
    }
}

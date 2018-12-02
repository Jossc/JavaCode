package com.sun.jvm.ClassLocader;

import com.basics.ClassLoaderTest.ClassLoaderLoadClass;

import java.util.concurrent.FutureTask;

/**
 * @ClassName VmClassLoader
 * @Despacito TODO 学习jvm
 * @Author chenzhuo
 * @Version 1.0
 **/
public class VmClassLoader {
    /**
     * 实例化在上
     * private static Singer singer = new Singer();
     * public static int count1 ;
     * public static int count2 =0;
     * count1:1
     * count2:0
     * <p>
     * <p>
     * public static int count1;
     * public static int count2 = 0;
     * private static Singer singer = new Singer();
     * count1:1
     * count2:1
     * @param args
     */
    public static void main(String[] args) {
      /*  ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        classLoader.loadClass();*/
        Class clazz ;

        Singer singer = Singer.getInstance();
        System.out.println("count1:" + singer.count1);
        System.out.println("count2:" + singer.count2);
    }

}

class Singer {
    public static int count1;
    public static int count2 = 0;
    private static Singer singer = new Singer();
    public Singer() {
        count1++;
        count2++;
    }

    public static Singer getInstance() {
        return singer;
    }


}

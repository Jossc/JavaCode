package com.sun.jvm.ClassLocader;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

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
        Stream stream;
        List<String> list = Arrays.asList("A","b","C","D");

        list.forEach(String::toLowerCase);

        list.forEach(l->{
            l.toLowerCase();
        });

        list.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                s.toLowerCase();
            }
        });

        for(String s:list){
            s.toLowerCase();
        }
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

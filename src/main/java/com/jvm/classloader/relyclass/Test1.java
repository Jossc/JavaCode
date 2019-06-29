package com.jvm.classloader.relyclass;

/**
 * @ClassName Test1
 * @Author chenzhuo
 * @Version 1.0
 * @Date 2019-06-25 22:06
 **/
public class Test1 {
    static {
        System.out.println(Test1.class.getClassLoader());
    }

    public static void main(String[] args) {
        System.out.println(System.getProperty("sun.boot.class.path"));
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println(System.getProperty("java.class.path"));
    }
}

package com.jvm.classloader.relyclass;

/**
 * @ClassName Test4
 * @Author chenzhuo
 * @Version 1.0
 * @Date 2019-06-30 21:35
 **/
public class Test4 {
    static {
        System.out.println("staci block");
    }

    public static void main(String[] args) {
        System.out.println("hello  test4");
    }
}

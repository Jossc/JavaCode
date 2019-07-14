package com.jvm.classloader.relyclass;

import java.util.Random;

/**
 * @ClassName Test6
 * @Author chenzhuo
 * @Version 1.0
 * @Date 2019-06-30 22:11
 **/
public class Test6 {

    public static void main(String[] args) {
        System.out.println(Test6_1.i);
    }
}

class Test6_1 {
    public static final int i = new Random().nextInt(100);

    static {
        System.out.println("test6_1 static block");
    }
}

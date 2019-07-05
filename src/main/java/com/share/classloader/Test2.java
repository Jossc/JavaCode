package com.share.classloader;

import java.util.Random;

/**
 * @author by chenzhuo
 * @Description
 * @Date 2019/7/2 15:22
 **/
public class Test2 {
    //iconst_  <-1,0,1,2 3,4,5>
    //iconst_m1

    //bipush 255
    //invokestaic
    //invoke dy
    //anewarray
    public static void main(String[] args) {
        //anewarray  class com/share/classloader/Test2_1
        Test2_1[] test2s = new Test2_1[10];
        String[] strings = new String[10];
        // L java/lang/Object
        System.err.println(test2s.getClass().getClassLoader());
        //newarray
        int[] ints = new int[10];
        //Ljava/lang/Object
        System.err.println(ints.getClass().getClassLoader());

    }
}

class Test2_1 {

    static {
        System.err.println("Test2_1 static block");
    }
}

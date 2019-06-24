package com.jvm.classloader.relyclass;

/**
 * @ClassName TestTwo
 * @Author chenzhuo
 * @Version 1.0
 * @Date 2019-06-16 00:42
 **/
public class TestTwo {
    public static void main(String[] args) {
        System.out.println(ParentTwo.s);
    }
}

class ParentTwo{
    public final  static String s="str";

    static {
        System.out.println("str str");
    }
}

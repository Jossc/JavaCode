package com.jvm.classloader.relyclass;

/**
 * @ClassName Test7
 * @Author chenzhuo
 * @Version 1.0
 * @Date 2019-06-30 22:35
 **/
public class Test7 {
    public static void main(String[] args) {
        System.out.println(Test7_2.i);
    }
}
class Test7_1{
    public static int i =5;
    static {
        System.out.println("Test7_1 static block");
    }
}
class Test7_2 extends Test7_1{
    static {
        System.out.println("Test7_2 static block");
    }
}

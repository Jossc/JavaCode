package com.jvm.classloader.relyclass;

/**
 * @ClassName TestFour
 * @Author chenzhuo
 * @Version 1.0
 * @Date 2019-06-16 17:36
 **/
public class TestFour {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getSingleton();
        System.out.println("a :" + Singleton.a);
        System.out.println("b :" + Singleton.b);
    }
}

class Singleton {
    public static int a;


    private static Singleton singleton = new Singleton();

    private Singleton() {
        a++;
        b++;
        System.out.println("singleton :" + b);
    }

    public static int b = 0;

    static Singleton getSingleton() {
        return singleton;
    }
}

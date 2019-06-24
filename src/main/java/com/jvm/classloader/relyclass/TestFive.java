package com.jvm.classloader.relyclass;

/**
 * @ClassName TestFive
 * @Author chenzhuo
 * @Version 1.0
 * @Date 2019-06-19 22:44
 **/
public class TestFive {

    public static void main(String[] args) throws Exception {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        Class clazz = classLoader.
                loadClass("com.jvm.classloader.relyclass.FiveTestClass");
        System.out.println(clazz);
        System.out.println("-------");
        clazz = Class.forName("com.jvm.classloader.relyclass.FiveTestClass");
        System.out.println(clazz.getName());
    }

}

class FiveTestClass {
    static {
        System.out.println("hello word");
    }
}

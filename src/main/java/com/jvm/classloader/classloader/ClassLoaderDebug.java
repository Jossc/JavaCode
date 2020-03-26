package com.jvm.classloader.classloader;

/**
 * @description: classLoaderD`ebug
 * @author: Crazy
 * @date: 2020/3/10 22:19
 */
public class ClassLoaderDebug {

    public static void main(String[] args) {

        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        System.out.println(classLoader);
    }
}

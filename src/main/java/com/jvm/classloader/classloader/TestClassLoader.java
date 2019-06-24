package com.jvm.classloader.classloader;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

/**
 * @ClassName TestClassLoader
 * @Author chenzhuo
 * @Version 1.0
 * @Date 2019-06-20 22:04
 **/
public class TestClassLoader {
    public static void main(String[] args) throws IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        String resource = "com/jvm/classloader/relyclass/TestFive.class";
        Enumeration<URL> enumeration = classLoader.getResources(resource);
        while (enumeration.hasMoreElements()) {
            URL url = enumeration.nextElement();
            System.out.println(url);
        }
        System.out.println("-----");
        Class<?> c = TestClassLoader.class;
        System.out.println(c.getClassLoader());

        TestClassLoader[] testClassLoaders = new TestClassLoader[10];
        System.out.println(testClassLoaders.getClass().getClassLoader());
        int[] ints = new int[10];
        System.out.println(ints.getClass().getClassLoader());
        String[] strings = new String[10];
        System.out.println(strings.getClass().getClassLoader());


    }
}

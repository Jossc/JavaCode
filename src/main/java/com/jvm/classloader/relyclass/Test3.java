package com.jvm.classloader.relyclass;

import com.jvm.classloader.classloader.ClassLoaderTest;

import java.lang.reflect.Method;

/**
 * @ClassName Test3
 * @Author chenzhuo
 * @Version 1.0
 * @Date 2019-06-26 23:03
 **/
public class Test3 {
    public static void main(String[] args) throws Exception {
        ClassLoaderTest classLoader1 = new ClassLoaderTest("loader1");
        ClassLoaderTest c2 = new ClassLoaderTest("loader2");
        Class<?> clazz1 = classLoader1.loadClass("com.jvm.classloader.relyclass.TestObject");
        Class<?> clazz2 = c2.loadClass("com.jvm.classloader.relyclass.TestObject");
        System.out.println(clazz1==clazz2);
        Object o1 = clazz1.newInstance();
        Object o2 = clazz2.newInstance();

        Method method = clazz1.getMethod("setTestObject",Object.class);
        method.invoke(o1,o2);


    }
}

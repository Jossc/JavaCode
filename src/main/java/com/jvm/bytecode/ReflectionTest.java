package com.jvm.bytecode;

import java.lang.reflect.Method;

/**
 * @ClassName ReflectionTest
 * @Author chenzhuo
 * @Version 1.0
 * @Date 2019-08-28 22:25
 **/
public class ReflectionTest {

    private static int count = 0;

    public static void foo(){
        new Exception("test#" + (count++)).printStackTrace();
    }

    public static void main(String[] args) throws Exception {
        Class<?> clazz= Class.forName("com.jvm.bytecode.ReflectionTest");
        Method method = clazz.getMethod("foo");
        for (int i = 0; i < 20; i++) {
            method.invoke(null);
        }

    }

}

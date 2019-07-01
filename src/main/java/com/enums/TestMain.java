package com.enums;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @ClassName TestMain
 * @Author chenzhuo
 * @Version 1.0
 * @Date 2019-06-18 22:26
 **/
public class TestMain {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class c = TestEnums.class;
        Object[] objects = c.getEnumConstants();
        Method name = c.getMethod("getName");
        Method age = c.getMethod("getGae");
        for (Object obj : objects) {
            System.out.println("name=" + name.invoke(obj) + "; age="
                    + age.invoke(obj));
        }
    }
}
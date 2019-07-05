package com.jvm.classloader.relyclass;

import java.lang.reflect.Field;
import java.sql.DriverManager;

/**
 * @ClassName Test1
 * @Author chenzhuo
 * @Version 1.0
 * @Date 2019-06-25 22:06
 **/
public class Test1 {

    static {
        System.out.println(Test1.class.getClassLoader());
    }

    public static void main(String[] args) throws  Exception {

    }
}

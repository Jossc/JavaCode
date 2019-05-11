package com.match;

import com.basics.ClassLoaderTest.classPathTest.ClassLoaderTest;
import com.basics.ClassLoaderTest.classPathTest.ObjectHello;

/**
 * @ClassName: ClassLoaderMain
 * @Description TODO
 * @Date 2019/1/23 17:04
 * @Created by chenzhuo
 **/
public class ClassLoaderMain {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        ClassLoaderTest loadClass = (ClassLoaderTest) ConextClassLoadTest.getThreadConextClassLoad(Thread.currentThread());

        Class<?> testClass = (Class<?>) loadClass.findClass("com.basics.ClassLoaderTest.classPathTest.ObjectHello");

        ObjectHello newInstance = (ObjectHello) testClass.newInstance();
        ObjectHello testClass1 = new ObjectHello();

    }
}

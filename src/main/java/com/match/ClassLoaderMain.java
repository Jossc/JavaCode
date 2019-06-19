package com.match;


/**
 * @ClassName: ClassLoaderMain
 * @Description TODO
 * @Date 2019/1/23 17:04
 * @Created by chenzhuo
 **/
public class ClassLoaderMain {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        com.basics.classloadertest.classPathTest.ClassLoaderTest loadClass = (com.basics.classloadertest.classPathTest.ClassLoaderTest) ConextClassLoadTest.getThreadConextClassLoad(Thread.currentThread());

        Class<?> testClass = (Class<?>) loadClass.findClass("com.basics.ClassLoaderTest.classPathTest.ObjectHello");

        com.basics.classloadertest.classPathTest.ObjectHello newInstance = (com.basics.classloadertest.classPathTest.ObjectHello) testClass.newInstance();
        com.basics.classloadertest.classPathTest.ObjectHello testClass1 = new com.basics.classloadertest.classPathTest.ObjectHello();

    }
}

package com.basics.ClassLoaderTest;

/**
 * PACKAGE_NAME: com.basics.ClassLoaderTest
 * MONTH_NAME_SHORT: 五月
 * USER: Clement
 **/
public class TestClassLoaderTest {
    public static void main(String []args){
        //loader : sun.misc.Launcher$AppClassLoader
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        System.err.println("loader : " + loader.getClass().getName());
    }
}

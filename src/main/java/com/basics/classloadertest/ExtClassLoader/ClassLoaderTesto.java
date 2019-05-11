package com.basics.classloadertest.ExtClassLoader;

/**
 * @ClassName ClassLoaderTesto
 * @Description TODO
 * @Author chenzhuo
 * @Date 2018/9/21 15:32
 * @Version 1.0
 **/
public class ClassLoaderTesto {

    public static void main(String[] args) {
        System.out.println("系统默认的AppClassLoader: "+ClassLoader.getSystemClassLoader());
        System.out.println("AppClassLoader的父类加载器: "+ClassLoader.getSystemClassLoader().getParent());
        System.out.println("ExtClassLoader的父类加载器: "+ClassLoader.getSystemClassLoader().getParent().getParent());
    }
}

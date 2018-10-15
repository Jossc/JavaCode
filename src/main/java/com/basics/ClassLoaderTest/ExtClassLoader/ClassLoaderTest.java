package com.basics.ClassLoaderTest.ExtClassLoader;

import java.util.List;

/**
 * @ClassName ClassLoaderTest
 * @Description TODO
 * @Author chenzhuo
 * @Date 2018/9/21 15:20
 * @Version 1.0
 * ClassLoaderText类的加载器的名称:sun.misc.Launcher$AppClassLoader
 * System类的加载器的名称:null
 * List类的加载器的名称:null
 * sun.misc.Launcher$AppClassLoader->sun.misc.Launcher$ExtClassLoader->null
 **/
public class ClassLoaderTest {

    public static void main(String[] args) {
        //输出ClassLoaderText的类加载器名称
        System.out.println("ClassLoaderText类的加载器的名称:"+ClassLoaderTest.class.getClassLoader().getClass().getName());
        //bootstap class
        System.out.println("System类的加载器的名称:"+System.class.getClassLoader());
        //bootstap class
        System.out.println("List类的加载器的名称:"+ List.class.getClassLoader());
        String var1 = System.getProperty("java.class.path");
        System.out.println("var0 :" +var1);
        ClassLoader cl = ClassLoaderTest.class.getClassLoader();
        while(cl != null){
            System.out.print(cl.getClass().getName()+"->");
            cl = cl.getParent();
        }
        System.out.println(cl);
    }

}

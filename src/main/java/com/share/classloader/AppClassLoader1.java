package com.share.classloader;

/**
 * @ClassName AppClassLoader1
 * @Author chenzhuo
 * @Version 1.0
 * @Date 2019-06-29 18:15
 **/
public class AppClassLoader1 {

    public static void main(String[] args) {
        //这是appClassLoader加载的
        System.out.println(AppClassLoader1.class.getClassLoader());
        //获取appClassLoader的类加载路径
        System.out.println(System.getProperty("java.class.path"));
        //ExtClassLoader
        System.out.println(AppClassLoader1.class.getClassLoader().getParent());

    }
}

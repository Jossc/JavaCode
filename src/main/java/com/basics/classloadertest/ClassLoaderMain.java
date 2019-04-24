package com.basics.classloadertest;

import java.lang.reflect.Method;
import java.net.URLClassLoader;

/**
 * @PACKAGE_NAME: com.basics.classloadertest
 * @PROJECT_NAME: JavaCode
 * @Date: 2018/4/20
 * @author: Jossc
 */
public class ClassLoaderMain {
    public static void main(String[] args) throws Exception{
        System.out.println("Hello World!");
        ClassLoaderManager manager = new ClassLoaderManager();
  /*
        添加jar包 maven聚合功能
        List<String> jarList = new ArrayList<String>();
        jarList.add(
                "");
        jarList.add(
                "");
        manager.setMoudleList(jarList);
        manager.init();*/

        ClassLoaderLoadClass classLoader = new ClassLoaderLoadClass(((URLClassLoader) ClassLoaderMain.class.getClassLoader()).getURLs(),manager);

        Class serviceA = classLoader.loadClass("org.moudleA.MoudleServiceA");
        Method sayHelloServiceA = serviceA.getMethod("sayHelloServiceA");
        String result = (String) sayHelloServiceA.invoke(serviceA.newInstance(), null);
        System.out.println(result);
    }
}

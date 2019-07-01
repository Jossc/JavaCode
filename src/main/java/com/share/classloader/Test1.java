package com.share.classloader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Test1
 * @Author chenzhuo
 * @Version 1.0
 * @Date 2019-06-30 14:32
 **/
public class Test1 {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello World!");
        ModuleManager manager = new ModuleManager();
        List<String> jarList = new ArrayList<String>();
        jarList.add("/Users/demons/IdeaProjects/JavaCode/moduleB/target/moduleBTest-1.0-SNAPSHOT.jar");
        jarList.add(
                "/Users/demons/IdeaProjects/JavaCode/moduleA/target/moduleTest-1.0-SNAPSHOT.jar");
        manager.setMoudleList(jarList);
        manager.init();

        ModuleClassLoader classLoader = new ModuleClassLoader(((URLClassLoader) Test1.class.getClassLoader()).getURLs(), manager);

        Class serviceA = classLoader.loadClass("org.moudleA.MoudleServiceA");
        Method sayHelloServiceA = serviceA.getMethod("sayHelloServiceA");
        String result = (String) sayHelloServiceA.invoke(serviceA.newInstance(), null);
        System.out.println(result);
    }
}

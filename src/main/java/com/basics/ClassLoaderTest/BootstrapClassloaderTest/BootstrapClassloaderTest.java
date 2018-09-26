package com.basics.ClassLoaderTest.BootstrapClassloaderTest;

import sun.security.action.GetPropertyAction;

import java.security.AccessController;

/**
 * @ClassName BootstrapClassloaderTest
 * @Description TODO
 * @Author chenzhuo
 * @Date 2018/9/21 15:50
 * @Version 1.0
 * see {@link java.security.AccessController}
 **/
public class BootstrapClassloaderTest {
    public static void main(String[] args) {
        //java.security
        /*String java_version = AccessController.doPrivileged(new GetPropertyAction("java.version"));
        String property = System.getProperty("java.version");
        String var2 = System.getProperty("java.security.manager");
        System.out.println("java_version: " + java_version);
        System.out.println("java_version: " + property);
        System.out.println("var2: " + property);*/
        BootstrapClassloaderTest test = new BootstrapClassloaderTest();
        test.test();
    }
    public void test(){
        SecurityManager security = System.getSecurityManager();
        /*System.out.println("s : "+ security.getThreadGroup().getName());*/
    }
}

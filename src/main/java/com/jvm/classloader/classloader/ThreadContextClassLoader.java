package com.jvm.classloader.classloader;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

/**
 * @description:
 * @author: Crazy
 * @date: 2020/3/11 21:42
 */
public class ThreadContextClassLoader {

    public static void main(String[] args) throws IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        System.out.println(classLoader);
        String res = "com/jvm/classloader/classloader/ClassLoaderDebug.class";
        Enumeration<URL> urls = classLoader.getResources(res);
        while (urls.hasMoreElements()) {
            System.out.println(urls.nextElement());
        }

    }
}

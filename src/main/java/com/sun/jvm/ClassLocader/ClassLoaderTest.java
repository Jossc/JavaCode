package com.sun.jvm.ClassLocader;

import com.sun.jvm.CountClssSize;
import com.sun.jvm.RewriteClassLoader;

import java.io.IOException;
import java.io.InputStream;

/**
 * @ClassName ClassLoaderTest
 * @Despacito TODO
 * @Author chenzhuo
 * @Version 1.0
 **/
public class ClassLoaderTest {

    public static void main(String[] args) throws ClassNotFoundException {
       /* ClassLoader testClassLoader =
                new ClassLoader() {
                    @Override
                    public Class<?> loadClass(String name) {
                        String fileName = name.substring(name.lastIndexOf(".")+1)+".class";
                        InputStream inputStream =
                                getClass().getResourceAsStream(fileName);
                        if(inputStream==null){
                            try {
                                return super.loadClass(name);
                            } catch (ClassNotFoundException e) {
                                e.printStackTrace();
                            }
                        }
                        try {
                            byte[] b = new byte[inputStream.available()];
                            inputStream.read(b);
                            return defineClass(name,b,0,b.length);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        return null;
                    }
                };*/
        RewriteClassLoader rewriteClassLoader = new RewriteClassLoader();
        Object object = rewriteClassLoader.loadClass("com.sun.jvm.CountClssSize");
        System.out.println(object instanceof CountClssSize);
        Thread thread;

    }
}

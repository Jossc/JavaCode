package com.basics.TestClassLoader;


import java.io.IOException;
import java.io.InputStream;

/**
 * PACKAGE_NAME: com.basics.TestClassLoader
 * MONTH_NAME_SHORT: 五月
 * USER: Clement
 **/
public class TestClass {
    /**
     * sun.misc.Launcher$AppClassLoader@18b4aac2
     * sun.misc.Launcher$ExtClassLoader@2a84aee7
     * null
     * @param args
     */
    public static void main(String []args){
        ClassLoader loader = TestClass.class.getClassLoader();
        while (loader!=null){
           // System.err.println(loader);
            loader = loader.getParent();
            //System.err.println("name :" + loader.getClass().getName());
        }

        try {
            test();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    /**
     * class com.basics.TestClassLoader.TestClass
     * true
     * class com.basics.TestClassLoader.TestClass
     * false
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public static void test() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        ClassLoader classLoader
                = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    System.err.println("name : " + name);
                   InputStream inputStream =
                           getClass().getResourceAsStream(name);
                    if (inputStream==null){
                        return super.loadClass(name);
                    }
                    byte [] b = new byte[inputStream.available()];
                    inputStream.read(b);

                    //return  findClass(name);
                    return defineClass(name,b,0,b.length);
                    //return loadClass("com.basics.TestClassLoader.TestClass");
                }catch (IOException e){
                    throw new ClassNotFoundException();
                }

            }
        };

        //使用JVM中的加载器加载
        Object object = TestClass.class.getClassLoader()
                .loadClass("com.basics.TestClassLoader.TestClass").newInstance();
        System.err.println(object.getClass());
        System.err.println(object instanceof com.basics.TestClassLoader.TestClass);

        //自定义的类加载器本类
        Object object2 = classLoader.loadClass("com.basics.TestClassLoader.TestClass").newInstance();
        System.err.println(object2.getClass());
        System.err.println(object2 instanceof com.basics.TestClassLoader.TestClass);
        System.err.println( object ==object2);
    }
}

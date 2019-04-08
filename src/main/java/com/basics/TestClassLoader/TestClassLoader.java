package com.basics.TestClassLoader;

import java.io.IOException;
import java.io.InputStream;

/**
 * PACKAGE_NAME: com.basics.TestClassLoader
 * MONTH_NAME_SHORT: 五月
 * USER: Clement
 **/
public class TestClassLoader {

    public static void main(String []args) throws IllegalAccessException, InstantiationException {
       /* ClassLoader classLoader
                 = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                return super.loadClass(name);
            }
        };*/
       MyClassLoader myClassLoader = new MyClassLoader();
       Object object = myClassLoader.loadClassMy().newInstance();
       System.err.println("emm :" + object.getClass().getName());
    }
    public static class MyClassLoader  extends ClassLoader{
        private Class<?> loadClassMy(){
            InputStream inputStream
                    = TestClassLoader.class.getResourceAsStream("TestClassLoader.class");

            try{
                int length = inputStream.available();
                byte[] buffer = new byte[length];
                inputStream.read(buffer,0,length);
                //findClass("com.basics.TestClassLoader.TestClassLoader");
                //loadClass("com.basics.TestClassLoader.TestClassLoader");
                return  defineClass("com.basics.TestClassLoader.TestClassLoader",buffer,0,length);
            }catch (IOException e){

            }
            return  null;
        }
    }

}

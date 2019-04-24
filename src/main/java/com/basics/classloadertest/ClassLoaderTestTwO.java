package com.basics.classloadertest;


/**
 * @PACKAGE_NAME: com.basics.classloadertest
 * @PROJECT_NAME: JavaCode
 * @Date: 2018/4/20
 * @author: Jossc
 */
public class ClassLoaderTestTwO {

    public static void main(String []args){
        ClassLoader classLoader
                = String.class.getClassLoader();
        //null
        System.out.println("class Loader : " + classLoader);
    }

}

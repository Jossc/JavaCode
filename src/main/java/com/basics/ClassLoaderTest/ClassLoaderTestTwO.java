package com.basics.ClassLoaderTest;


/**
 * @PACKAGE_NAME: com.basics.ClassLoaderTest
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

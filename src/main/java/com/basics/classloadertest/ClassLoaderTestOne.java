package com.basics.classloadertest;

import java.net.URL;

/**
 * @PACKAGE_NAME: com.basics.classloadertest
 * @PROJECT_NAME: JavaCode
 * @Date: 2018/4/20
 * @author: Jossc
 */
public class ClassLoaderTestOne {
    public static void main(String []args){
        ClassLoader classLoader =
                ClassLoaderTestOne.class.getClassLoader();
        //sun.misc.Launcher$AppClassLoader@b4aac2
        System.out.println("emm : " + classLoader);
        //sun.misc.Launcher$ExtClassLoader@7b84de
        System.out.println("emm parent : " + classLoader.getParent());
        findBootstrapClassloader();
    }

    /**
     * BootstrapClassloader
     * 不是java实现的 底层用C写的 所以这么找
     * file:/C:/java/jre/lib/resources.jar
     * file:/C:/java/jre/lib/rt.jar
     * file:/C:/java/jre/lib/sunrsasign.jar
     * file:/C:/java/jre/lib/jsse.jar
     * file:/C:/java/jre/lib/jce.jar
     * file:/C:/java/jre/lib/charsets.jar
     * file:/C:/java/jre/lib/jfr.jar
     * file:/C:/java/jre/classes
     */
    public static void findBootstrapClassloader(){
        URL[] urls
                = sun.misc.Launcher.getBootstrapClassPath().getURLs();
        for(int i =0;i<urls.length;i++){
            System.out.println(urls[i].toExternalForm());
        }
    }
}

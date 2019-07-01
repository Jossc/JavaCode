package com.share.classloader;

import java.net.URL;

/**
 * @ClassName BootstrapClassloader1
 * @Author chenzhuo
 * @Version 1.0
 * @Date 2019-06-29 18:24
 **/
public class BootstrapClassloader1 {
    public static void main(String[] args) {
        URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
        for (URL url : urls) {
            System.out.println(url.toExternalForm());
        }

        ClassLoader cl = String.class.getClassLoader();
        System.err.println(cl);
    }
}

package com.jvm.classloader.classloader;

import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandlerFactory;

/**
 * @author by chenzhuo
 * @Description
 * @Date 2019/6/26 11:15
 **/
public class UrlClassLoaderTest extends URLClassLoader {


    public UrlClassLoaderTest(URL[] urls) {
        super(urls);
    }

    public UrlClassLoaderTest(URL[] urls, ClassLoader parent) {
        super(urls, parent);
    }

    public UrlClassLoaderTest(URL[] urls, ClassLoader parent, URLStreamHandlerFactory factory) {
        super(urls, parent, factory);
    }


}

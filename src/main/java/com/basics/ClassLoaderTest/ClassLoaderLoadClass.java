package com.basics.ClassLoaderTest;

import java.net.URL;
import java.net.URLClassLoader;

/**
 * @PACKAGE_NAME: com.basics.ClassLoaderTest
 * @PROJECT_NAME: JavaCode
 * @Date: 2018/4/20
 * @author: Jossc
 */
public class ClassLoaderLoadClass extends URLClassLoader {

    public ClassLoaderLoadClass(URL[] urls, ClassLoader parent) {
        super(urls, parent);
    }
}

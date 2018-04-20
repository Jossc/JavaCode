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
    private  ClassLoaderManager classLoaderManager = new ClassLoaderManager();
    public ClassLoaderLoadClass(URL[] urls, ClassLoaderManager classLoaderManager) {
        super(urls);
        this.classLoaderManager =classLoaderManager;
    }
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {

        if(classLoaderManager.getCache().containsKey(name)){
            return classLoaderManager.getCache().get(name);
        }else{
            return super.loadClass(name, resolve);
        }
    }
}

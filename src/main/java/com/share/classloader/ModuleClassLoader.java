package com.share.classloader;

import java.net.URL;
import java.net.URLClassLoader;

/**
 * @ClassName ModuleClassLoader
 * @Author chenzhuo
 * @Version 1.0
 * @Date 2019-06-30 14:30
 **/
public class ModuleClassLoader extends URLClassLoader {

    private ModuleManager manager;

    public ModuleClassLoader(URL[] urls, ModuleManager manager) {
        super(urls);
        this.manager = manager;
    }

    @Override
    protected Class<?> loadClass(String name, boolean resolve)
            throws ClassNotFoundException {

        if (manager.getCache().containsKey(name)) {
            return manager.getCache().get(name);
        } else {
            return super.loadClass(name, resolve);
        }
    }

}

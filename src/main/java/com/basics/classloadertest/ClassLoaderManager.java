package com.basics.classloadertest;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * @PACKAGE_NAME: com.basics.classloadertest
 * @PROJECT_NAME: JavaCode
 * @Date: 2018/4/20
 * @author: Jossc
 * 不同模块加载 Jar 面的类到内存 map里
 */
public class ClassLoaderManager {
    private ExecutorService executor = Executors.newFixedThreadPool(8);
    private Map<String,Class> cache = new ConcurrentHashMap<>();
    private List<String> moudleList= new ArrayList<String>();

    public Map<String, Class> getCache() {
        return cache;
    }

    public void setCache(Map<String, Class> cache) {
        this.cache = cache;
    }

    public List<String> getMoudleList() {
        return moudleList;
    }

    public void setMoudleList(List<String> moudleList) {
        this.moudleList = moudleList;
    }

    private String getClassName(JarEntry entry) {
        String entryName = entry.getName();

        if (!entryName.endsWith(".class")) {
            return null;
        }
        if (entryName.charAt(0) == '/') {
            entryName = entryName.substring(1);
        }
        entryName = entryName.replace("/", ".");
        System.out.println("entryName: " +entryName);
        return entryName.substring(0, entryName.length() - 6);
    }
}

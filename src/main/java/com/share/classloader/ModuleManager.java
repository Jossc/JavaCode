package com.share.classloader;

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
 * @ClassName ModuleManager
 * @Author chenzhuo
 * @Version 1.0
 * @Date 2019-06-30 14:22
 **/
public class ModuleManager {
    private ExecutorService executor = Executors.newFixedThreadPool(8);
    private Map<String, Class> cache = new ConcurrentHashMap<>();
    private List<String> moudleList = new ArrayList<>();


    private String getClassName(JarEntry entry) {
        String endsWith = ".class";
        String entryName = entry.getName();
        if (!entryName.endsWith(endsWith)) {
            return null;
        }
        if (entryName.charAt(0) == '/') {
            entryName = entryName.substring(1);
        }
        entryName = entryName.replace("/", ".");
        return entryName.substring(0, entryName.length() - 6);
    }

    public void init() {

        System.out.println("----begin load  All module----");
        List<Future<String>> futureList = new ArrayList<>();
        for (String module : moudleList) {
            Future<String> future = executor.submit(() -> {
                try {
                    URL[] moduleUrl = new URL[]{new URL("file://" + module)};
                    @SuppressWarnings("resource")
                    URLClassLoader classLoader = new URLClassLoader(moduleUrl);
                    @SuppressWarnings("resource")
                    JarFile jar = new JarFile(new File(module));
                    Enumeration<JarEntry> entries = jar.entries();
                    while (entries.hasMoreElements()) {
                        JarEntry entry = entries.nextElement();
                        String className = getClassName(entry);
                        if (className == null) {
                            continue;
                        }

                        try {
                            Class<?> clazz = classLoader.loadClass(className);
                            //缓存jar 里面的 Class 对象。
                            cache.put(className, clazz);
                        } catch (Throwable t) {

                        }
                    }
                } catch (Exception e) {
                    System.out.println(e.getLocalizedMessage());
                }
                return module;
            });
            futureList.add(future);
        }

        for (Future<String> future : futureList) {
            try {
                String moduleName = future.get();
                System.out.println("---load module " + moduleName + " ok");
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        executor.shutdown();
        System.out.println("----end load All module----");

    }

    public Map<String, Class> getCache() {
        return cache;
    }

    public List<String> getMoudleList() {
        return moudleList;
    }

    public void setMoudleList(List<String> moudleList) {
        this.moudleList = moudleList;
    }
}

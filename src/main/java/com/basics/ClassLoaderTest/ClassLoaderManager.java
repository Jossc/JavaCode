package com.basics.ClassLoaderTest;

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
 * @PACKAGE_NAME: com.basics.ClassLoaderTest
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

    public void init(){

        System.out.println("---- load all ----");
        List<Future<String>> futureList = new ArrayList<>();
        for(String moudle:moudleList){
            Future<String> future = executor.submit(() -> {
                try{
                    URL[] moduleUrl = new URL[]{new URL("file://"+ moudle)};
                    @SuppressWarnings("resource")
                    URLClassLoader classLoader = new URLClassLoader(moduleUrl );
                    @SuppressWarnings("resource")
                    JarFile jar = new JarFile(new File(moudle));
                    Enumeration<JarEntry> entries = jar.entries();
                    while (entries.hasMoreElements()) {
                        JarEntry entry = entries.nextElement();
                        String className = getClassName(entry);
                        if (className == null ) {
                            continue;
                        }

                        try {
                            Class<?> clazz = classLoader.loadClass(className);
                            //放到内存里
                            cache.put(className, clazz);
                        } catch (Throwable t) {
                            //System.out.println(t.getLocalizedMessage());
                        }
                    }
                }catch(Exception e){
                    System.out.println(e.getLocalizedMessage());
                }

                return moudle;
            });
            futureList.add(future);
        }

        for(Future<String> future:futureList){
            try {
                String moduleName = future.get();
                System.out.println("---load moudle " + moduleName + " ok" );
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        executor.shutdown();
        System.out.println("----end load All module----");

    }
}

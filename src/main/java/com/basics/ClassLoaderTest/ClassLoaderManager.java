package com.basics.ClassLoaderTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.jar.JarEntry;

/**
 * @PACKAGE_NAME: com.basics.ClassLoaderTest
 * @PROJECT_NAME: JavaCode
 * @Date: 2018/4/20
 * @author: Jossc
 * 不同模块加载 Jar 里面的类到内存 map
 */
public class ClassLoaderManager {
    private ExecutorService executorService
             = Executors.newFixedThreadPool(8);
    private Map<String,Class> map = new ConcurrentHashMap<>();
    private List<String> list = new ArrayList<>();

    /**
     * 截取className
     * @param entry
     * @return
     */
    private String getClassName(JarEntry entry){
        String entryName = entry.getName();
        if(!entryName.endsWith(".class")){
            return null;
        }
        if(entryName.charAt(0)=='/'){
            entryName = entryName.substring(1);
        }
        entryName = entryName.replaceAll(",",".");
        System.out.println("entryName : " +entryName);
        return entryName.substring(0,entryName.length());
    }

    /**
     * 初始化
     */
    public void init(){
        System.out.println("begin --- load ----");
        List<Future<String>> futures
                = new ArrayList<>();
        for(String mudel : list){

        }
    }
}

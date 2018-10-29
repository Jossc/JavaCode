package com.basics.ClassLoaderTest.ExtClassLoader;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @ClassName ExtClassLoaderTest
 * @Description TODO
 * @Author chenzhuo
 * @Date 2018/9/21 9:41
 * @Version 1.0
 **/
public class ExtClassLoaderTest {

    public static void main(String[] args) {
        ExtClassLoaderTest extClassLoaderTest
                 = new ExtClassLoaderTest();
        File[] test = extClassLoaderTest.test();

       List<File> list =  Arrays.asList(test);
        list.forEach(file -> {
            System.out.println(file.getName());
        });
    }

    public File[] test(){
        //加载java_home/lib/ext/目录下
        String s = System.getProperty("java.ext.dirs");
        System.out.println("s : " + s );
        File[] dirs;
        if(s!=null){
            StringTokenizer stringTokenizer
                    = new StringTokenizer(s,File.pathSeparator);
            int count = stringTokenizer.countTokens();
            System.out.println("basicsThread :" + count);
            dirs = new File[count];
            for (int i = 0; i < count; i++) {
                dirs[i] = new File(stringTokenizer.nextToken());
            }
        }else {
            dirs = new File[0];
        }
        return dirs;
    }
}

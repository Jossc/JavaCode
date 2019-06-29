package com.share.classloader;

import com.sun.crypto.provider.AESKeyGenerator;

/**
 * @ClassName ExtClassloader1
 * @Author chenzhuo
 * @Version 1.0
 * @Date 2019-06-29 18:20
 **/
public class ExtClassloader1 {

    public static void main(String[] args) {
        System.out.println(System.getProperty("java.ext.dirs"));
        AESKeyGenerator aesKeyGenerator = new AESKeyGenerator();
        ClassLoader classLoader = aesKeyGenerator.getClass().getClassLoader();
        //sun.misc.Launcher$ExtClassLoader@13221655
        System.out.println(classLoader);
        //null
        System.out.println(classLoader.getParent());
    }
}

package com.jvm.classloader.relyclas;

import com.sun.crypto.provider.AESKeyGenerator;

/**
 * @ClassName Test2
 * @Author chenzhuo
 * @Version 1.0
 * @Date 2019-06-26 22:35
 **/
public class Test2 {
    public static void main(String[] args) {
        AESKeyGenerator aesKeyGenerator = new AESKeyGenerator();
        //sun.misc.Launcher$ExtClassLoader@13221655
        System.out.println(aesKeyGenerator.getClass().getClassLoader());
        System.out.println(Test2.class.getClassLoader());
    }
}

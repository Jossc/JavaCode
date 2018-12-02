package com.jdk8.lmb.lam_interface.impl;


import com.jdk8.lmb.lam_interface.LamInterfaceTest;
import com.sun.org.apache.regexp.internal.RE;

import java.util.concurrent.Callable;

/**
 * @ClassName InterFaceTest
 * @Despacito TODO
 * @Author chenzhuo
 * @Version 1.0
 **/
public class InterFaceTest {
    public static void main(String[] args) {

        Callable callable = ()->{
            return "" ;
        };
        LamInterfaceTest interfaceTest = ()-> {
            System.out.println("hello : " + System.currentTimeMillis());
            return "hello Word";
        };
        String string = interfaceTest.getString();
        System.out.println("string:"+string );
    }
}

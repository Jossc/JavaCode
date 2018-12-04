package com.jdk8.lmb.lam_interface.impl;


import com.jdk8.lmb.lam_interface.LamInterfaceTest;
import com.jdk8.lmb.lam_interface.TestInterFace;
import com.sun.org.apache.regexp.internal.RE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.Consumer;

/**
 * @ClassName InterFaceTest
 * @Despacito TODO
 * @Author chenzhuo
 * @Version 1.0
 **/
public class InterFaceTest {

    public InterFaceTest() {

    }

    public InterFaceTest(TestInterFace testInterFace) {
        System.out.println("run----");
        String s = new String();
        testInterFace.test(s);
        System.out.println("run end----");
    }

    public static void main(String[] args) {

     /*   Callable callable = ()->{
            return "" ;
        };
        LamInterfaceTest interfaceTest = ()-> {
            System.out.println("hello : " + System.currentTimeMillis());
            return "hello Word";
        };
        String string = interfaceTest.getString();
        System.out.println("string:"+string );

        InterFaceTest interFaceTest = new InterFaceTest((s)->{
            s = s+ "" + new Date().getTime();
            System.out.println(s);
        });*/
        /**
         * className:com.jdk8.lmb.lam_interface.impl.InterFaceTest$$Lambda$1/1358444045
         * classParent:java.lang.Object
         */
        TestInterFace testInterFace = (myString) ->
                System.out.println("paramer:" + myString.getClass().getName());
        System.out.println("className:" + testInterFace.getClass().getName());
        System.out.println("classParent:" + testInterFace.getClass().getSuperclass().getName());
        //interfaceLength:interface com.jdk8.lmb.lam_interface.TestInterFace
        System.out.println("interfaceLength:" + testInterFace.getClass().getInterfaces()[0]);
        Class<?>[] interfaces = testInterFace.getClass().getInterfaces();
        List<Class<?>> classes = Arrays.asList(interfaces);
        classes.forEach(s->{
            System.out.println(s.getClass().getName());
        });
        classes.forEach(new Consumer() {
            @Override
            public void accept(Object o) {
                System.out.println(o);
            }
        });


    }
}

package com.jvm.classloader.interfaceclass;

/**
 * @ClassName TestInterface
 * @Author chenzhuo
 * @Version 1.0
 * @Date 2019-06-18 22:40
 **/
public class TestInterface {

    public static void main(String[] args) {
        System.out.println(MyInterfaceImpl.i);
    }
}

interface MyInterface {
    //int a =5;
    Thread thread = new Thread() {
        {
            System.out.println("is out?");
        }
    };
}

interface MyInterfaceTest extends MyInterface {
    int b = 6;
}

class MyInterfaceImpl implements MyInterface {
    public static int i = 10;
}


package com.jvm.bytecode;

/**
 * @author by chenzhuo
 * @Description
 * @Date 2019/7/9 10:55
 **/
public class A {


}

class C {
    static {
        System.out.println("C init");
    }

    public C() {
        System.out.println("C Instance");
    }

}

class B extends C {
    static {
        System.out.println("B init");
    }

    public B() {
        System.out.println("B Instance");
    }
    public static void main(String[] args) {
        C c = new B();
    }

}


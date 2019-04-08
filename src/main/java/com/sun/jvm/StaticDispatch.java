package com.sun.jvm;

/**
 * @ClassName StaticDispatch
 * @Despacito TODO
 * @Author chenzhuo
 * @Version 1.0
 **/
public class StaticDispatch {
    static  abstract class h{

    }
    static class  A extends  h{

    }
    static class B extends h{

    }

    public void hello(h h){
        System.out.println("ccc");
    }
    public void hello(A h){
        System.out.println("ccc1");
    }
    public void hello(B h){
        System.out.println("ccc2");
    }

    public static void main(String[] args) {
        h h = new B();
        h c = new A();
        StaticDispatch staticDispatch = new StaticDispatch();
        staticDispatch.hello(h);
        staticDispatch.hello(c);
    }
}

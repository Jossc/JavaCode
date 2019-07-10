package com.jvm.bytecode;

/**
 * @author by chenzhuo
 * @Description
 * @Date 2019/7/9 14:13
 **/
public class ChangeableSubclass extends Changeable {

    @Override
    void invoke(Object obj, Object... args) {
        System.err.println("this is method first");
    }

    @Override
    void invoke(String s, Object object, Object... args) {
        System.err.println("this is method second");
    }

    void test1(Object object, Object ib) {
        System.err.println("method first");

    }

    void test1(String hello, Object o) {
        System.err.println("method second");

    }

    public static void main(String[] args) {
     /*   Changeable changeable = new ChangeableSubclass();
        changeable.invoke(null, 1);
        changeable.invoke(null, 1, 2);
        changeable.invoke(null, new Object[]{1});*/
        ChangeableSubclass subclass = new ChangeableSubclass();
        subclass.test1(1, 1);
        subclass.test1(111, 11);

    }
}

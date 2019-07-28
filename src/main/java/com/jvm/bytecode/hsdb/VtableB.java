package com.jvm.bytecode.hsdb;

/**
 * @ClassName VtableB
 * @Author chenzhuo
 * @Version 1.0
 * @Date 2019-07-28 09:40
 **/
public class VtableB extends VtableA {

    @Override
    public void sayHello() {

        System.out.println("hello, i am child B");
    }
}

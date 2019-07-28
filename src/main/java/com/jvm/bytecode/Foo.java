package com.jvm.bytecode;


import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * @ClassName Foo
 * @Author chenzhuo
 * @Version 1.0
 * @Date 2019-07-28 21:28
 **/
public class Foo {
    public void print(String s) {
        System.out.println("hello :" + s);
    }

    public static void main(String[] args) throws Throwable {
        Foo foo = new Foo();
        System.out.println(void.class.getClassLoader());
        MethodType methodType = MethodType.methodType(void.class,String.class);
        MethodHandle methodHandle = MethodHandles.lookup().
                findVirtual(Foo.class, "print", methodType);
        methodHandle.invokeExact(foo, "world");
    }
}

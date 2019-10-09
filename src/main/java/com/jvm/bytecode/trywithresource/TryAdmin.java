package com.jvm.bytecode.trywithresource;

/**
 * @ClassName TryAdmin
 * @Author chenzhuo
 * @Version 1.0
 * @Date 2019-08-28 22:01
 **/
public class TryAdmin {

    public static void foo(){

    }

    /**
     * 这里直接抛出异常
     */
    public static void bar() {
        throw new RuntimeException("bar exception");
    }
}

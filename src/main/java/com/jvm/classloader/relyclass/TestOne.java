package com.jvm.classloader.relyclass;

/**
 * @ClassName TestOne
 * @Author chenzhuo
 * @Version 1.0
 * @Date 2019-06-10 21:08
 * <p>
 * 1.对于静态字段，只有使用了直接定义了该字段的类才会被初始化（主动使用了定义了静态字段的类）
 * 2.执行子类的时候，会优先初始化其父类(因为要求其父类初始化完毕，每个父类都只会初始化一次)。
 *  -XX:+TraceClassLoading 用来显示类的加载信息，并打印出来
 *
 **/
public class TestOne {

    static {
        System.err.println("classPath :" + TestOne.class.getClassLoader());
    }

    public static void main(String[] args) {

    }
}


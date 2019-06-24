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

    public static void main(String[] args) {
        System.out.println(TestChild.s);
    }
}

class TestOneParent {
    /**
     * 如果是final static 修饰，在编译期间就会确定和初始化值，如果有子类或者自身引用 不会初始化static
     */
    public static final String sh = "skr skr";

    public static String s = "Hello word";

    static {
        System.out.println("this  static  block");
    }

}

class TestChild extends TestOneParent {
    public static String skr = "skr";
    static {
        System.out.println("child  one static  block");
    }
}
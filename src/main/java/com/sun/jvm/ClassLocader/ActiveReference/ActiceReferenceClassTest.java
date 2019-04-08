package com.sun.jvm.ClassLocader.ActiveReference;

/**
 * @ClassName ActiceReferenceClassTest
 * @Despacito TODO 主动引用测试
 * @Author chenzhuo
 * @Version 1.0
 **/
public class ActiceReferenceClassTest {
    static {
        System.out.println(" init ");
    }
    public static  int vlaue =1;
}
class A extends  ActiceReferenceClassTest{
    static {
        System.out.println("a init ");
    }
}

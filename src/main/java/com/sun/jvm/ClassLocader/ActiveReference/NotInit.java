package com.sun.jvm.ClassLocader.ActiveReference;

/**
 * @ClassName NotInit
 * @Despacito TODO -XX:+TraceClassLoading 查看类加载记录
 * @Author chenzhuo
 * @Version 1.0
 **/
public class NotInit {
  //  public static int anInt =10;
    static {
        anInt =1;
        //TODO 非法的向前引用
      //  System.out.println(anInt);
    }
    private static int anInt =10;
    public static void main(String[] args) {
      //  System.out.println(ActiceReferenceClassTest.vlaue);
     //   ActiceReferenceClassTest[] acticeReferenceClassTests = new  ActiceReferenceClassTest[10];
        System.out.println(ActiceReferenceClassTestTwo.s);
    }
}

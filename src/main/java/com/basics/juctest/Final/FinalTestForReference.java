package com.basics.juctest.Final;

/**
 * @ClassName FinalTestForReference
 * @Description TODO
 * @Author chenzhuo
 * @Date 2018/10/8 15:31
 * @Version 1.0
 * final 作用引用类型
 **/
public class FinalTestForReference {
    final int[] intArray;
    public int[] ints;
    static FinalTestForReference finalTestForReference;

    public FinalTestForReference() {
        intArray = new int[1];
        intArray[0] = 1;
        ints = new int[1];
        ints[0] = 2;
    }

    public static void wirte() {
        finalTestForReference = new FinalTestForReference();
    }
    public static  void read(){
        int i = finalTestForReference.intArray[0];
        System.out.println("i :" + i);
        int b = finalTestForReference.ints[0];
        System.out.println("b: " + b);
    }
}
package com.sun.jvm.Jvm;

/**
 * @ClassName SimpleTrench
 * @Despacito TODO
 * @Author chenzhuo
 * @Version 1.0
 **/
public class SimpleTrench {
    public void localVar1(){
        int a =0;
        System.out.println(a);
        int b =0;
    }
    public void localVar2(){
        {
            int a =0;
            System.out.println(a);
        }
        int b =0;
    }

    public static void main(String[] args) {
        System.out.println("hello word");
    }
}

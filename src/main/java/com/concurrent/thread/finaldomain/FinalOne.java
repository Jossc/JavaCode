package com.concurrent.thread.finaldomain;

/**
 * @ClassName FinalOne
 * @Author chenzhuo
 * @Version 1.0
 * @Date 2019-07-14 22:53
 **/
public class FinalOne {
    private final int anInt;

    public FinalOne(int anInt) {
        this.anInt = anInt;
    }

    public static void main(String[] args) {
        FinalOne finalOne = new FinalOne(100);
        System.out.println(finalOne.anInt);
    }
}

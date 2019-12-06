package com.datastructure.array;

/**
 * 数组测试
 * 目的
 * 验证数组是一片连续内存
 *
 * @ClassName ArrayTest
 * @Author chenzhuo
 * @Version 1.0
 * @Date 2019/12/5 12:19 下午
 **/
public class ArrayTest {

    public static void main(String[] args) {
        int[] ints  = new int[]{
                Integer.MAX_VALUE,
                Integer.MAX_VALUE,
                Integer.MAX_VALUE,
                Integer.MAX_VALUE,
                Integer.MAX_VALUE,
                Integer.MAX_VALUE,
                Integer.MAX_VALUE};
        System.out.println(ints.getClass());
        System.out.println(ints.length);
        System.out.println(ints.hashCode());

        int[] newInt = new int[10];
        System.out.println(newInt.length);
    }
}

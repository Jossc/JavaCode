package com.jvm.memory;

/**
 * @description:
 * @author: Crazy
 * @date: 2020/4/4 17:19
 */
public class StringTest {


    public static void main(String[] args) {
        String string = "abc";
        String s = string.intern();
        System.out.println(s);
    }

}

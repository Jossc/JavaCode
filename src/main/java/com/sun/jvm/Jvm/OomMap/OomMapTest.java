package com.sun.jvm.Jvm.OomMap;

/**
 * PACKAGE_NAME: com.sun.jvm.Jvm.OomMap
 * MONTH_NAME_SHORT: 一月
 * USER: chenzhuo
 **/
public class OomMapTest {
    public static void main(String[] args) throws InterruptedException {
        String s = "2";
        String test = s.intern();
        Thread.sleep(100000);
        System.out.println(test);
    }
}

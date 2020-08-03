package com.basics.UnsafeTest.unsafe_voliate;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 * @ClassName UnsafeTestTwo
 * @Description TODO
 * @Author chenzhuo
 * @Date 2018/8/22 11:20
 * @Version 1.0
 *
 * pageSize 内存页大小 :4096
 * address  :8  变量指针的长度（4/8 32/64系统）
 * anLong :12
 **/
public class UnsafeTestTwo {
    public static Unsafe unsafe;
    public int anInt;
    public  static long anLong;
    static {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe = (Unsafe) field.get(null);
            anLong = unsafe.objectFieldOffset(UnsafeTestTwo.class.getDeclaredField("anInt"));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        UnsafeTestTwo unsafeTestTwo = new UnsafeTestTwo();
        System.out.println(" pageSize :" +unsafe.pageSize());
        System.out.println("address  :" + unsafe.addressSize());
        unsafe.putInt(UnsafeTestTwo.class,anLong,10);
        int unsafeInt = unsafe.getInt(UnsafeTestTwo.class, anLong);
        System.out.println("anInt: " + unsafeInt);
        System.out.println("anLong : " + anLong);
       /* unsafeTestTwo.testSys();*/
        try {
            UnsafeTestTwo o = (UnsafeTestTwo) unsafe.allocateInstance(UnsafeTestTwo.class);
            //2055281021  ---   1554547125
            System.out.println("true or false :" +o.hashCode() + " hash" + unsafeTestTwo.hashCode());
            /*   o.testSys();*/
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    public  void testSys() {
        System. out. println("array scale "+unsafe .arrayBaseOffset(ArrayList.class));
        System. out . println("array scale "+unsafe. arrayBaseOffset (UnsafeTestTwo[].class));
        System. out . println("array scale "+unsafe. arrayBaseOffset (Long.class));
        System. out . println("array scale "+unsafe . arrayBaseOffset (Boolean[].class));
        System. out . println("array i scale "+unsafe. arrayBaseOffset (int[]. class));
        System. out . println("array scale"+unsafe . arrayBaseOffset (Integer.class));
        System. out . println("array scale "+unsafe . arrayBaseOffset (Byte.class));
    }
}


package com.basics.UnsafeTest.unsafe_voliate.model;

import com.basics.UnsafeTest.unsafe_voliate.UnsafeTestTwo;
import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @ClassName ObjectInHeap
 * @Description TODO
 * @Author chenzhuo
 * @Date 2018/8/23 11:44
 * @Version 1.0
 *  堆外内存
 **/
public class ObjectInHeap {
    private long address = 0;

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

    public ObjectInHeap()
    {
        address = unsafe.allocateMemory(2 * 1024 * 1024);
    }

    // Exception in thread "main" java.lang.OutOfMemoryError
    public static void main(String[] args) {
        //unsafe.allocateInstance()
       /* while (true)
        {
            ObjectInHeap heap = new ObjectInHeap();
            System.out.println("memory address=" + heap.address);
        }*/
    }
}

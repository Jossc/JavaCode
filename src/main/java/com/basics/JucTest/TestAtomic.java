package com.basics.JucTest;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @ClassName TestAtomic
 * @Description TODOStampedLock
 * @Author chenzhuo
 * @Date 2018/8/20 9:51
 * @Version 1.0
 **/
public class TestAtomic {
    static Unsafe unsafe;
    private static volatile  long state = 0 ;
    static {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe = (Unsafe) field.get(null);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        TestAtomic atomic = new TestAtomic();
        try {
            atomic.setInt(1);
            int i = atomic.getInt();
            System.out.println("i： " + i);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public int getInt() throws NoSuchFieldException {
        return unsafe.getInt(10);
    }

    public void setInt(int value) throws NoSuchFieldException {
        unsafe.putInt(10, value);
    }


}

package com.basics.UnsafeTest;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @PACKAGE_NAME: com.basics.UnsafeTest
 * @PROJECT_NAME: JavaCode
 * @Date: 2018/4/19
 * @author: Jossc
 * 因为Unsafe是Bootstrap 类加载的
 * 但是UnsafeTestOne是AppClassLoader类加载器加载的
 * 所以出现java.lang.SecurityException: Unsafe异常
 */
public class UnsafeTestOne {
    private static Unsafe unsafe;
    private static  long stateOffset;
    private static volatile  long state = 0 ;
    static {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
             unsafe = (Unsafe) field.get(null);
             stateOffset = unsafe.
                     objectFieldOffset(UnsafeTestOne.class.getDeclaredField("state"));
        } catch (NoSuchFieldException e) {
            System.out.println(e.getLocalizedMessage());
            throw new Error(e);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
    public static void main(String []args ){
        UnsafeTestOne testOne = new UnsafeTestOne();
        Boolean b = unsafe.compareAndSwapInt(testOne,stateOffset,0,1);
        System.out.println(" sucess : "+ b);
    }

}



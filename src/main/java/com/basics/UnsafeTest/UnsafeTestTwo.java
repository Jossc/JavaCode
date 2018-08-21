package com.basics.UnsafeTest;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @PACKAGE_NAME: com.basics.UnsafeTest
 * @PROJECT_NAME: JavaCode
 * @Date: 2018/4/19
 * @author: Jossc
 * 黑科技反射获取Unsafe
 */
public class UnsafeTestTwo {
    private  static final Unsafe unsafe ;

    private  static final long stateOffset;
    private  volatile  long state = 0;

    static {
        try{
             Field field = Unsafe.class.getDeclaredField("theUnsafe");
             field.setAccessible(true);
             unsafe = (Unsafe) field.get(null);
             stateOffset =
                    unsafe.objectFieldOffset(UnsafeTestTwo.class.
                            getDeclaredField("state"));
            System.out.println("stateOffset: " +stateOffset);
        }catch (Exception e){
            System.out.println(e.getLocalizedMessage());
            throw new Error(e);
        }
    }

    public static  void  main(String []args){
        UnsafeTestTwo unsafeTestTwo = new UnsafeTestTwo();
        Boolean b  = unsafe.compareAndSwapInt(unsafeTestTwo,stateOffset,0,1);
        System.out.println("success : " + b);

    }
}

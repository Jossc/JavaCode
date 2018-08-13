package com.basics.JavaassistTest;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @ClassName ParkUntilTest
 * @Description TODO
 * @Author chenzhuo
 * @Date 2018/8/13 11:20
 * @Version 1.0
 * 屠龙之技 unsafe。
 **/
public class ParkUntilTest {
    static Unsafe unsafe;

    /**
     * 获取unsafe实例
     */
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
}


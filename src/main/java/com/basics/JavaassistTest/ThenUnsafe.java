package com.basics.JavaassistTest;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * PACKAGENAME: com.basics.JavaassistTest
 * USER : chenzhuo
 * MONTH_NAME_SHORT: 八月
 * -----类位移偏量
 **/
public class ThenUnsafe {
    static final Unsafe unsafe;
    static final long stateOffset;
    private static final long SEED;
    private static final long PROBE;
    private static final long SECONDARY;
    private volatile long state = 0;
    static {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe = (Unsafe) field.get(null);
            Class<?> tk = Thread.class;
            SEED = unsafe.objectFieldOffset(tk.getDeclaredField(
                    "threadLocalRandomSeed"));
            PROBE = unsafe.objectFieldOffset
                    (tk.getDeclaredField("threadLocalRandomProbe"));
            SECONDARY = unsafe.objectFieldOffset
                    (tk.getDeclaredField("threadLocalRandomSecondarySeed"));
            stateOffset = unsafe.objectFieldOffset(ThenUnsafe.class.getDeclaredField("state"));
         /*   unsafe = (Unsafe) field.get(null);
            */
        } catch (Exception ex) {

            System.out.println(ex.getLocalizedMessage());
            throw new Error(ex);
        }
    }
    public static void main(String[] args) {
        ThenUnsafe test = new ThenUnsafe();
        Boolean sucess = unsafe.compareAndSwapInt(test, stateOffset, 0, 1);
        System.out.println(stateOffset);
        System.out.println(SEED);
        System.out.println(PROBE);
        System.out.println(SECONDARY);

    }
}

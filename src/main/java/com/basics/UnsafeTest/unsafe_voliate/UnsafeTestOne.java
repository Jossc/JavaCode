package com.basics.UnsafeTest.unsafe_voliate;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * PACKAGE_NAME: com.basics.UnsafeTest.unsafe_voliate
 * MONTH_NAME_SHORT: 六月
 * USER: Clement
 **/
public class UnsafeTestOne {

    public static void main(String []args) throws NoSuchFieldException, IllegalAccessException {

        Unsafe unsafe = getUnsafe();
        ExecutorService executors = Executors.newFixedThreadPool(2);
        executors.execute(new TestRun());
        unsafe.fullFence();
        Future future = executors.submit(new TestRun());
        boolean cancelled = future.isCancelled();
        System.err.println("boolean :" +cancelled);
        unsafe.loadFence();
        List<Runnable> runnables = executors.shutdownNow();
        runnables.stream().forEach(s->{
            System.err.println("name: " + s.getClass().getName());
        });

    }


    public static Unsafe getUnsafe() throws NoSuchFieldException, IllegalAccessException {
        Field field =  Unsafe.class.getDeclaredField("theUnsafe");
        field.setAccessible(true);
        Unsafe unsafe = (Unsafe) field.get(null);
        return  unsafe;
    }

    public static class TestRun implements Runnable{
        int i = 0;
        @Override
        public void run() {
            while (i<5){
                System.err.println("i : " + (i=i+1));
            }
        }
    }
}

package com.basics.ThreadLocalTest;

import java.lang.ref.WeakReference;

/**
 * PACKAGENAME: com.basics.ThreadLocalTest
 * USER : chenzhuo
 * MONTH_NAME_SHORT: 七月
 * WeakReference 弱引用
 *
 * ReferenceQueue :引用队列
 *
 **/
public class ThreadLocalEntryTest  extends WeakReference<ThreadLocal<?>> {
    public ThreadLocalEntryTest(ThreadLocal<?> referent) {
        super(referent);
        System.out.println("value : "+referent.get());
        System.out.println("key : " +  " rua");
    }

    public static void main(String []args){

    }
}

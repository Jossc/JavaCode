package com.basics.JavaassistTest;


import com.sun.xml.internal.bind.v2.TODO;
import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.locks.LockSupport;

/**
 * PACKAGENAME: com.basics.JavaassistTest
 * USER : chenzhuo
 * MONTH_NAME_SHORT: 八月
 **/
public class LockSupportSupperOne {
    static final Unsafe unsafe;
    private volatile long state = 0;
    static {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe = (Unsafe) field.get(null);
        } catch (Exception ex) {
            System.out.println(ex.getLocalizedMessage());
            throw new Error(ex);
        }

    }
   /* public static  ThreadLocal<String> threadLocal
             = ThreadLocal.withInitial(()->{
                  return  new String();
    });
    public static  ThreadLocal<String> threadLocal1
            = ThreadLocal.withInitial(()->{
        return  new String();
    });

    public static  void main(String []args){
        threadLocal.get();
        threadLocal.set("测试环境111111");
        threadLocal1.get();
        threadLocal1.set("测试一瞎:"+ System.nanoTime());
        String s = threadLocal1.get();
        String s1 = threadLocal.get();
        System.out.println("测试----------- ： " +s );
        System.out.println("测试一瞎： " +s1 );
    }*/


   public static void main(String [] args){
       System.out.println("开始挂机");
       unsafe.park(false,1000L);
       Thread  thread = new Thread(()->
               unsafe.unpark(Thread.currentThread())
       );
       thread.start();
       System.out.println("end ----------");


     /*  testLock();
      testLockSupport();*/
   }

   /**
    * 一直挂起，因为没有当前线程的许可
    */
   public  static  void testLockSupport(){
      System.out.println("start ----------");
      LockSupport.park();
      System.out.println("end ----------");
   }

    /**
     * 自己封装 unsafe 和 LockSupport.park()
     * 一样 查看源码可知 LockSupport.park 封装了   unsafe.park(false,0);
     */
   public static void testPark(){
       unsafe.park(false,0);
   }

    /**
     * 给当前线程许可，
     * 让unsafe 可以拿到当前线程许可
     */
   public static void testLock(){
       LockSupport.unpark(Thread.currentThread());
   }

    /**
     *  自己封装 unsafe 和 LockSupport.unpark()
     *  一样 查看源码可知 LockSupport.unpark 封装了   unsafe.unpark(false,0);
     * @param thread
     */
    public static void unpark(Thread thread) {
        if (thread != null)
            unsafe.unpark(thread);
    }

}

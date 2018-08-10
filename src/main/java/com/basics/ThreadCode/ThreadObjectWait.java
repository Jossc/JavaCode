package com.basics.ThreadCode;

import sun.misc.Unsafe;
import java.lang.reflect.Field;
/**
 * @ClassName ThreadObjectWait
 * @Description TODO
 * @Author chenzhuo
 * @Date 2018/8/10 16:26
 * @Version 1.0
 *
 * 写出了智障的代码
 *
 *   public static void main(String []args){
 *         Thread thread = new Thread(()->{
 *             System.out.println("开始中断。。。。。。");
 *         });
 *         thread.start();
 *         unPark(thread);
 *         park(100000L);
 *        // thread.wait();
 *     }
 *      public static void park(){
 *         System.out.println("开始挂机---------");
 *         unsafe.park(false,0L);
 *     }
 *     public static void unPark(Thread thread){
 *         System.out.println("开始授权认证---------:" + thread.getName() );
 *         unsafe.unpark(thread.currentThread());
 *     }
 *     public static void park(long endTime){
 *         unsafe.unpark(1000000L);
 *     }
 *
 **/
public class ThreadObjectWait {
    static final Unsafe unsafe;
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
   /* static {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe = (Unsafe) field.get(null);
        } catch (NoSuchFieldException e) {
            System.out.println(e.getLocalizedMessage());
            throw new Error(e);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }*/


    /**
     * #
     * # A fatal error has been detected by the Java Runtime Environment:
     * #
     * #  EXCEPTION_ACCESS_VIOLATION (0xc0000005) at pc=0x00000000753a6cc0, pid=9108, tid=0x0000000000005948
     * #
     * # JRE version: Java(TM) SE Runtime Environment (8.0_181-b13) (build 1.8.0_181-b13)
     * # Java VM: Java HotSpot(TM) 64-Bit Server VM (25.181-b13 mixed mode windows-amd64 compressed oops)
     * # Problematic frame:
     * # V  [jvm.dll+0x1e6cc0]
     * #
     * # Failed to write core dump. Minidumps are not enabled by default on client versions of Windows
     * #
     * # An error report file with more information is saved as:
     * # D:\whyJava\JavaCode\hs_err_pid9108.log
     * #
     * # If you would like to submit a bug report, please visit:
     * #   http://bugreport.java.com/bugreport/crash.jsp
     * #
     * @param args
     */
    public static void main(String []args) throws InterruptedException {
      Thread thread = new Thread(()->{
          System.out.println("child thread begin park!");
          park();
          System.out.println("child thread unpark!");
      });
        thread.start();
        Thread.sleep(1000);
        System.out.println("main thread begin unpark!");
        unPark(thread);

    }
    /**
     * 直接挂机
     */
    public static void park(){
        System.out.println("开始挂机---------");
        unsafe.park(false,0L);
    }
    /**
     * 给当前线程
     * @param
     */
    public static void unPark(Thread thread){
        unsafe.unpark(thread);
    }
    public static void park(long endTime){
        unsafe.unpark(endTime);
    }
    public static void stat(){
        park(100000L);
        System.out.println("开始授权认证---------:");
        unsafe.unpark(Thread.currentThread());
    }
}

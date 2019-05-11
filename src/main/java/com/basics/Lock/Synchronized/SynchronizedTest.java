package com.basics.Lock.Synchronized;

/**
 * PACKAGE_NAME: com.basics.Lock.Synchronized
 * MONTH_NAME_SHORT: 十月
 * USER: Clement
 *
 **/
public class SynchronizedTest {

    private static Object object = new Object();
    /**
     * public static void main(java.lang.String[]);
     *     descriptor: ([Ljava/lang/String;)V
     *     flags: ACC_PUBLIC, ACC_STATIC
     *     Code:
     *       stack=2, locals=3, args_size=1
     *          0: ldc           #2                  // class com/basics/Lock/Synchronized/SynchronizedTest
     *          2: dup
     *          3: astore_1
     *          4: monitorenter   //开始加锁
     *          5: new           #2                  // class com/basics/Lock/Synchronized/SynchronizedTest
     *          8: dup
     *          9: invokespecial #3                  // Method "<init>":()V
     *         12: invokevirtual #4                  // Method m:()V
     *         15: aload_1
     *         16: monitorexit   //释放锁
     *         17: goto          25
     *         20: astore_2
     *         21: aload_1
     *         22: monitorexit
     *         23: aload_2
     *         24: athrow
     *         25: return
     * @param args
     */
    public static void main(String[] args) {
        synchronized (SynchronizedTest.class){
            new SynchronizedTest().m();
        }
        SynchronizedTest synchronizedTest = new SynchronizedTest();
        synchronizedTest.m();
    }

    private void test(){
        synchronized (object){
            System.out.println("hello ");
        }
    }

    /**
     * public synchronized void m();
     *     descriptor: ()V
     *     flags: ACC_PUBLIC, ACC_SYNCHRONIZED
     */
    public synchronized void m(){

    }
}

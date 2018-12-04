package com.sun.jvm.Jvm;

/**
 * @ClassName SimpleHeapTest
 * @Despacito TODO
 * @Author chenzhuo
 * @Version 1.0
 **/
public class SimpleHeapTest {
    /**
     * byte[] placeholder = new byte[64 * 1024 * 1024];
     * System.gc()
     * [GC (System.gc())  70779K->66480K(251392K), 0.0010415 secs]
     * [Full GC (System.gc())  66480K->66317K(251392K), 0.0050595 secs]
     *
     *
     *         {
     *              byte[] placeholder = new byte[64 * 1024 * 1024];
     *         }
     *         int a =0;
     *         System.gc();
     *
     *  [GC (System.gc())  70779K->66499K(251392K), 0.0012833 secs]
     * [Full GC (System.gc())  66499K->781K(251392K), 0.0059161 secs]
     * @param args
     */
    public static void main(String[] args) {
        {
             byte[] placeholder = new byte[64 * 1024 * 1024];
        }
        int a =0;
        System.gc();
    }
}

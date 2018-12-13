package com.sun.jvm.Jvm;

/**
 * @ClassName SimpleFuGcTest
 * @Despacito TODO
 * @Author chenzhuo
 * @Version 1.0
 * -Xmx6m -XX:+PrintGC
 **/
public class SimpleFuGcTest {
    //a 不能被回收 ,因为a再被引用
    public void localvarGc1() {
        /**
         * [GC (Allocation Failure)  1536K->765K(7680K), 0.0007301 secs]
         * [GC (Allocation Failure)  1216K->845K(7680K), 0.0006823 secs]
         * [GC (Allocation Failure)  845K->861K(7680K), 0.0005386 secs]
         * [Full GC (Allocation Failure)  861K->744K(7680K), 0.0045683 secs]
         * [GC (Allocation Failure)  744K->744K(7680K), 0.0002421 secs]
         * [Full GC (Allocation Failure)  744K->726K(7680K), 0.0055514 secs]
         */
        byte[] a = new byte[6 * 1024 * 1024];
        System.gc();
    }

    /**
     *
     */
    //a可以被会收,因为a是null
    public void localvarGc2() {
        byte[] a = new byte[6 * 1024 * 1024];
        a = null;
       /* System.gc();*/
    }

    public void localvarGc3() {
        {
            byte[] a = new byte[6 * 1024 * 1024];
        }
        System.gc();
    }

    /**
     * [GC (System.gc())  8163K->6985K(9728K), 0.0010397 secs]
     * [Full GC (System.gc())  6985K->750K(9728K), 0.0056459 secs]
     */
    public void localvarGc4() {
        {
            byte[] a = new byte[6 * 1024 * 1024];
        }
        int c = 10;
        System.gc();
    }

    public void localvarGc5() {
        localvarGc1();
        System.gc();
    }

    public static void main(String[] args) {
        SimpleFuGcTest ins=new SimpleFuGcTest();
        ins.localvarGc4();
    }

    @Override
    public String toString() {
        return "SimpleFuGcTest{}";
    }
}


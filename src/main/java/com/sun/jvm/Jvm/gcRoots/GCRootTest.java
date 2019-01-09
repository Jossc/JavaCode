package com.sun.jvm.Jvm.gcRoots;

/**
 * @ClassName GCRootTest
 * @Despacito TODO
 * @Author chenzhuo
 * @Version 1.0
 * -Xmx200M -Xms200M -Xmn100M  -XX:+UseParNewGC  -XX:+UseConcMarkSweepGC
 * -XX:+UseCMSInitiatingOccupancyOnly  -XX:CMSInitiatingOccupancyFraction=75 -XX:+PrintGCDetails
 * gc回收算法
 * 可达回收算法
 * 这个算法的基本思路就是通过一系列的称为"GC Roots"的对象作为起始点，
 * 从这些节点开始向下搜索，搜索所走过的路径称为引用链（Reference Chain），
 * 当一个对象到GC Roots没有任何引用链相时，则证明此对象是不可用的
 * next 这个是可以达到但是next 却没有引用 所以gc在回收的时候 需要遍历next 这个对象
 * next = null 直接赋值为null,可以帮助gc
 * {@link java.util.concurrent.locks.AbstractQueuedSynchronizer}
 * acquireQueued
 * final boolean acquireQueued(final Node node, int arg) {
 *         boolean failed = true;
 *         try {
 *             boolean interrupted = false;
 *             for (;;) {
 *                 final Node p = node.predecessor();
 *                 if (p == head && tryAcquire(arg)) {
 *                     setHead(node);
 *                     p.next = null; // help GC
 *                     failed = false;
 *                     return interrupted;
 *                 }
 *                 if (shouldParkAfterFailedAcquire(p, node) &&
 *                     parkAndCheckInterrupt())
 *                     interrupted = true;
 *             }
 *         } finally {
 *             if (failed)
 *                 cancelAcquire(node);
 *         }
 *     }
 *
 * 在Java语言中，可作为GC Roots的对象包括下面几种：
 *      虚拟机栈（栈帧中的本地变量表）中引用的对象。
 *      方法区中类静态属性引用的对象。
 *      方法区中常量引用的对象。
 *      本地方法栈中JNI（即一般说的Native方法）引用的对象。
 **/
public class GCRootTest {
    private static final int _1MB = 1024 * 1024;
    private static final int LENGTH = 40000000;

    /**
     * gc日志
     * [GC (Allocation Failure) [ParNew: 1064551K->133120K(1198080K), 15.8236844 secs] 1064551K->938838K(3962880K), 15.8237292 secs] [Times: user=113.70 sys=1.11, real=15.82 secs]
     * Heap
     * par new generation   total 1198080K, used 1131502K [0x00000006c6000000, 0x0000000717400000, 0x0000000717400000)
     * eden space 1064960K,  93% used [0x00000006c6000000, 0x0000000702efb898, 0x0000000707000000)
     * from space 133120K, 100% used [0x000000070f200000, 0x0000000717400000, 0x0000000717400000)
     * to   space 133120K,   0% used [0x0000000707000000, 0x0000000707000000, 0x000000070f200000)
     * concurrent mark-sweep generation total 2764800K, used 805718K [0x0000000717400000, 0x00000007c0000000, 0x00000007c0000000)
     * Metaspace       used 3741K, capacity 4540K, committed 4864K, reserved 1056768K
     * class space    used 409K, capacity 428K, committed 512K, reserved 1048576K
     *
     * @param args
     */
    public static void main(String[] args) {
        Node next = null;
        for (int i = 0; i <= LENGTH; i++) {
            Node node = new Node(i, next);
            next = node;
        }
        next = null;
        triggerGC();
        /**
         *  gc日志
         * [GC (Allocation Failure) [ParNew: 1064551K->847K(1198080K), 0.0038396 secs] 1064551K->847K(3962880K), 0.0039093 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
         * Heap
         *  par new generation   total 1198080K, used 967281K [0x00000006c6000000, 0x0000000717400000, 0x0000000717400000)
         *   eden space 1064960K,  90% used [0x00000006c6000000, 0x0000000700fc8548, 0x0000000707000000)
         *   from space 133120K,   0% used [0x000000070f200000, 0x000000070f2d3ff0, 0x0000000717400000)
         *   to   space 133120K,   0% used [0x0000000707000000, 0x0000000707000000, 0x000000070f200000)
         *  concurrent mark-sweep generation total 2764800K, used 0K [0x0000000717400000, 0x00000007c0000000, 0x00000007c0000000)
         *  Metaspace       used 3223K, capacity 4500K, committed 4864K, reserved 1056768K
         *   class space    used 349K, capacity 388K, committed 512K, reserved 1048576K
         */
        //没有设置为null的时候,回收的时候会遍历next的所以节点,所以会很耗时间
        //但是把next的set为null的时候 就变为不可达状态
       // next = null; help gc

    }

    private static void triggerGC() {
        //new一个大对象 它可能直接就到old区去了。
//        byte[] all = new byte[2000 * _1MB];
        for (int i = 0; i < 500; i++) {
            byte[] bytes = new byte[2 * _1MB];
        }
    }

    static class Node {
        private int valuel;
        private Node node;
        public Node(int valuel, Node node) {
            this.valuel = valuel;
            this.node = node;
        }
        public int getValuel() {
            return valuel;
        }
        public void setValuel(int valuel) {
            this.valuel = valuel;
        }
        public Node getNode() {
            return node;
        }
        public void setNode(Node node) {
            this.node = node;
        }
    }
}

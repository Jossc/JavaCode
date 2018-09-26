package com.basics.queue.QueueQu.ConcurrentLinkedQueue;


import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * PACKAGE_NAME: com.basics.queue.QueueQu.ConcurrentLinkedQueue
 * MONTH_NAME_SHORT: 九月
 * USER: Clement
 * concurrentLinkedQueue
 * {@link java.util.concurrent.ConcurrentLinkedQueue}
 * '
 *
 * public boolean offer(E e) {
 *
 *       tail === 尾部节点
 *
 *      //检测e是不是为空，如果为空就直接抛异常
 *
 *         checkNotNull(e);
 *         //构建新的node节点
 *         final Node<E> newNode = new Node<E>(e);
 *
 *         // 从尾部节点开始拆入
 *         for (Node<E> t = tail, p = t;;) {
 *             //把p的下一个节点复制给q
 *             Node<E> q = p.next;
 *             //如果q是null的话,说明p是尾部节点
 *             if (q == null) {
 *                 //在p节点后插入newNode
 *                 if (p.casNext(null, newNode)) {
 *                     cas成功，则说明新增节点已经被放入链表，然后设置当前尾节点
 *                     if (p != t) // hop two nodes at a time
 *                         casTail(t, newNode);  // Failure is OK.
 *                     return true;
 *                 }
 *             }
 *             else if (p == q)
 *                 p = (t != (t = tail)) ? t : head;
 *             else
 *                   //寻找新的尾部节点
 *                 p = (p != t && t != (t = tail)) ? t : q;
 *         }
 *     }
 **/
public class ConcurrentLinkedQueueTest {
    public static void main(String[] args) {
        test();
    }

    public static void test(){
        ConcurrentLinkedQueue concurrentLinkedQueue
                = new ConcurrentLinkedQueue();

      /*  concurrentLinkedQueue.offer(new String("123"));
        concurrentLinkedQueue.offer(new String("123"));
        concurrentLinkedQueue.offer(new String("123"));*/

      Object  o = concurrentLinkedQueue.poll();
      System.out.println("is? : " + o);
      String var1 = System.getProperty("java.class.path");
      System.out.println("var1? : " + var1);
    }
}

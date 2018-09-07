package com.basics.JucTest;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @ClassName CopyOnWriteArrayListTest
 * @Description TODO
 * @Author chenzhuo
 * @Date 2018/8/13 17:12
 * @Version 1.0
 * CopyOnWriteArrayList 测试
 **/
public class CopyOnWriteArrayListTest {
    private static volatile CopyOnWriteArrayList<String>
            arrayList = new CopyOnWriteArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        CopyOnWriteArrayListTest copyOnWriteArrayListTest = new CopyOnWriteArrayListTest();
        copyOnWriteArrayListTest.testList();
    }

    public void testList() throws InterruptedException {
        Thread threadOne = new Thread(() -> {
            arrayList.set(1, "baba");
            //删除元素
            arrayList.remove(2);
            arrayList.remove(3);
        });
        /**
         *  threadOne.start();
         *  //等在子线程执行完毕
         *  threadOne.join();
         *  Iterator<String> itr = arrayList.iterator();
         *  while (itr.hasNext()) {
         *    System.out.println(itr.next());
         *  }
         * 弱一致性
         * 优先执行遍历，然后才能修改
         */
        Iterator<String> itr = arrayList.iterator();
        threadOne.start();
        threadOne.join();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }  //启动线程

    }



}

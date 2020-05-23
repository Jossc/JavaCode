package com.thread.count;

import java.util.concurrent.CountDownLatch;

/**
 * @description:
 * @author: Crazy
 * @date: 2020/3/28 21:16
 */
public class CountDownLatchTest {

    private final CountDownLatch countDownLatchOne = new CountDownLatch(1);

    private final CountDownLatch countDownLatchTwo = new CountDownLatch(1);

    private final CountDownLatch countDownLatchThree = new CountDownLatch(3);


    public static void main(String[] args) throws InterruptedException {
        /*new CountDownLatchTest().testMethodOne();*/
        CountDownLatchTest countDownLatchTest = new CountDownLatchTest();
        /*countDownLatchTest.runThreadOne();
        countDownLatchTest.runThreadTwo();
        countDownLatchTest.runThreadThree();*/
        countDownLatchTest.runThreadMethodOne();
        countDownLatchTest.runThreadMethodTwo();
        countDownLatchTest.runThreadMethodThree();
    }

    public void testMethodOne() throws InterruptedException {
        Thread threadOne = new Thread(() -> {
            System.out.println("this thread one");
        });

        Thread threadTwo = new Thread(() -> {
            System.out.println("this thread two");
        });

        Thread threadThree = new Thread(() -> {
            System.out.println("this thread three");
        });

     /*   threadOne.start();
        threadOne.join();
        threadTwo.start();
        threadTwo.join();
        threadThree.start();
        threadThree.join();*/

    }


    public void runThreadMethodOne() {
        Thread threadOne = new Thread(() -> {
            System.out.println("this thread one");
        });
        threadOne.start();
        countDownLatchThree.countDown();
    }

    public void runThreadMethodTwo() {
        Thread threadTwo = new Thread(() -> {
            System.out.println("this threadTwo");
        });
        threadTwo.start();
        countDownLatchThree.countDown();
    }

    public void runThreadMethodThree() {
        Thread threadTwo = new Thread(() -> {
            System.out.println("this ThreadThree");
        });
        threadTwo.start();
        countDownLatchThree.countDown();
    }

    public void runThreadOne() {
        Thread threadOne = new Thread(() -> {
            System.out.println("this thread one");
        });
        threadOne.start();
        countDownLatchOne.countDown();
    }

    public void runThreadTwo() throws InterruptedException {
        countDownLatchOne.await();
        Thread threadTwo = new Thread(() -> {
            System.out.println("this thread Two");
        });
        threadTwo.start();
        countDownLatchTwo.countDown();
    }


    public void runThreadThree() throws InterruptedException {
        Thread threadTwo = new Thread(() -> {
            System.out.println("this thread three");
        });
        threadTwo.start();
        countDownLatchTwo.await();
    }


}

package com.concurrent.thread.wait;

/**
 * @author 一方通行
 * @title: CountTestTwo
 * @projectName JavaCode
 * @date 2020/8/28 17:59
 */
public class CountTestTwo {
    public static int counter;

    public static Object lock = new Object();

    public static void increase() throws InterruptedException {
        synchronized (lock) {
            while (counter != 0) {
                lock.wait();
            }
            counter++;
            System.out.println(counter);
            lock.notify();
        }
    }

    public static void decrease() throws InterruptedException {
        synchronized (lock) {
            while (counter == 0) {
                lock.wait();
            }
            counter--;
            System.out.println(counter);
            lock.notify();
        }
    }

    public static void main(String[] args) {
        Thread addCount = new Thread(() -> {
            try {
                increase();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread subtractionCount = new Thread(() -> {
            try {
                decrease();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        addCount.start();
        subtractionCount.start();

    }

}

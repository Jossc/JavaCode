package com.concurrent.newstart;

/**
 * @author by chenzhuo
 * @Description 死锁
 * @Date 2019/7/10 16:02
 **/
public class DeadLockDemon {
    private static String A = "A";
    private static String B = "B";

    public static void main(String[] args) {
        new DeadLockDemon().deadLock();
    }

    private void deadLock() {
        Thread thread = new Thread(() -> {
            synchronized (A) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (B) {
                    System.err.println("B");
                }
            }

        });
        Thread thread1 = new Thread(() -> {
            synchronized (B) {
                synchronized (A) {
                    System.err.println("A");
                }
            }
        });
        thread.start();
        thread1.start();
    }
}

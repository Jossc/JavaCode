package com.thread.inaction;

/**
 * @description:
 * @author: Crazy
 * @date: 2020/5/2 11:06
 */
public class NoVisibility {

    private static boolean ready;

    private static int number;

    private static class ReadThread extends Thread {

        public void run() {
            while (!ready) {
                Thread.yield();
            }
            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        new ReadThread().start();
        number = 42;
        ready = true;
    }
}

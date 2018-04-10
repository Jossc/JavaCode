package com.basics.ThreadCode.ThreadConection;

import java.util.ArrayList;

public class ArrayListMultThread {
    public static ArrayList<Integer> list = new ArrayList<>();

    public static  class AddThread implements Runnable{

        @Override
        public void run() {
            for(int i =0;i<10000;i++){
                list.add(i);
            }
        }
    }

    /**
     Exception in thread "Thread-0" java.lang.ArrayIndexOutOfBoundsException: 33
     at java.util.ArrayList.add(ArrayList.java:459)
     at com.basics.ThreadCode.ThreadConection.
     ArrayListMultThread$AddThread.run(ArrayListMultThread.java:13)
     at java.lang.Thread.run(Thread.java:745)
     10030
     * @param args
     * @throws InterruptedException
     */
    public static void main(String []args) throws InterruptedException {
        Thread thread = new Thread(new AddThread());
        Thread thread1 = new Thread(new AddThread());
        thread.start();
        thread1.start();
        thread.join();thread1.join();
        System.err.println(list.size());
    }
}

package com.concurrent.thread.happendbefore;

/**
 * @ClassName ThreadStart
 * @Author chenzhuo
 * @Version 1.0
 * @Date 2019-07-22 22:36
 **/
public class ThreadStart {

    public int i;

    public int j;

    static ThreadStart threadStart;

    public ThreadStart(int i, int j) {
        this.i = i;
        this.j = j;
        threadStart = this;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            reader();
        });
        Thread thread = new Thread(() -> {
            write();
            thread1.start();
        });
        thread.join();
        thread.start();
        thread1.start();

    }

    public static void reader() {
        int j = threadStart.j;
        int i = threadStart.i;
        System.out.println(i + "----" + j);
    }

    public static void write() {
        new ThreadStart(100, 50);
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }
}

class RunnableTest extends Thread {
    public int i;

    public int j;


    public RunnableTest(int i, int j) {
        this.i = i;
        this.j = j;
    }


    @Override
    public void run() {
        i--;
        j--;
    }
}

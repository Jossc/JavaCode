package com.concurrent.volatilelearn;

/**
 * @ClassName VolatileTwo
 * @Despacito 一写多读的场景
 * @Author chenzhuo
 * @Version 1.0
 **/
public class VolatileTwo {
    private volatile int test;

    /**
     * volatile值保证内存可见性
     *
     * @return
     */
    public int getTest() {
        return test;
    }

    /**
     * 修改值的时候枷锁
     *
     * @param test
     */
    public synchronized void setTest(int test) {
        this.test = test;
    }

    public static void main(String[] args) {
        VolatileTwo volatileTwo = new VolatileTwo();
        volatileTwo.getTest();

    }
}

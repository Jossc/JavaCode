package com.concurrent.testsynchronized;

import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 一方通行
 * @title: TestSynchronized
 * @projectName JavaCode
 * @date 2020/8/24 23:07
 */
@SpringBootApplication
public class TestSynchronized {

    private final static Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        new TestSynchronized().sayHello();
    }

    public void sayHello() throws InterruptedException {
        synchronized (lock) {
            System.out.println("hello word");
            wait();
        }
    }
    public void hha() throws InterruptedException {
        synchronized (lock) {
            System.out.println("hello word");
            // do xxx
        }
    }
}

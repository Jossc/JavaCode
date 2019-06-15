package com.concurrent.volatilelearn;

/**
 * @ClassName VolatileOne
 * @Despacito TODO
 * @Author chenzhuo
 * @Version 1.0
 **/
public class VolatileOne {
    /**
     * 状态标志并不依赖于程序内任何其他状态，所以这里非常适合使用 volatile
     */
    private volatile boolean showDownStatus;

    public static void main(String[] args) {
    }

    private void showDown() {
        showDownStatus = true;
    }

    /**
     这里在循环外调用showDown
     */
    public void doWorker() {
        while (!showDownStatus) {
            runTest();
        }
    }

    private void runTest() {
        System.out.println("hello word");
    }


}

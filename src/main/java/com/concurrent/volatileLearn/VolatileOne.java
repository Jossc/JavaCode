package com.concurrent.volatileLearn;

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
    private volatile boolean SHOW_DOWN_STATUS;

    public static void main(String[] args) {
        int i =100;
        int b = 200;
        /*if((i>b||(i&&b))){

        }*/
    }

    private void showDown() {
        SHOW_DOWN_STATUS = false;
    }

    /**
     这里在循环外调用showDown
     */
    public void doWorker() {
        while (SHOW_DOWN_STATUS) {
            runTest();
        }
    }

    private void runTest() {
        System.out.println("hello word");
    }


}

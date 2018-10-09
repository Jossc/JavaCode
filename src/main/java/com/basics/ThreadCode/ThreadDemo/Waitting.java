package com.basics.ThreadCode.ThreadDemo;


/**
 * @ClassName Waitting
 * @Description TODO
 * @Author chenzhuo
 * @Date 2018/10/9 15:43
 * @Version 1.0
 **/
public class Waitting implements Runnable {
    @Override
    public void run() {
        while (true){
            synchronized (Waitting.class){
                try {
                    Waitting.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

package com.concurrent.thread.demonthread;

/**
 * @ClassName DamonThread
 * @Author chenzhuo
 * @Version 1.0
 * @Date 2019-07-16 23:34
 **/
public class DamonThread {
    public static void main(String[] args) {
        Thread thread = new Thread(new DameonRunner(),"damonRunner");
        thread.setDaemon(true);
        thread.start();

    }

}
class DameonRunner implements Runnable{

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("this  run over");
        }
    }
}

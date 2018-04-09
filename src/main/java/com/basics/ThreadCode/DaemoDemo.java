package com.basics.ThreadCode;

/**
 * 守护线程
 */
public class DaemoDemo {
    public static class Demo extends  Thread{
        public void run(){
            while (true){
                System.err.println("id"+Thread.currentThread().getId());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void main(String [] args){
        Thread t = new Demo();
        t.setDaemon(true);
        t.start();
        //Exception in thread "main" java.lang.IllegalThreadStateException
        //t.setDaemon(true);
    }
}

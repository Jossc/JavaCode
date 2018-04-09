package com.basics.ThreadCode;

public class ThreadGruopName implements Runnable {
    @Override
    public void run() {
        String name
                = Thread.currentThread().getThreadGroup().getName()
                +"-"+Thread.currentThread().getName();
        while (true){
            System.err.println("Name : " + name);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static  void main(String []args){
        ThreadGroup threadGroup
                = new ThreadGroup("PrintGruop");
        Thread thread = new Thread(threadGroup,new ThreadGruopName(),"t1");
        Thread thread1 = new Thread(threadGroup,new ThreadGruopName(),"t2");
        thread.start();
        thread1.start();
        System.err.println("count :" + threadGroup.activeCount());
        threadGroup.list();
    }
}

package com.concurrent.thread.threaddemo;

/**
 * @ClassName ChangeObjectThread
 * @Author chenzhuo
 * @Version 1.0
 * @Date 2019-07-20 23:58
 **/
public class ChangeObjectThread extends Thread {
    public User user;

    public ChangeObjectThread(User user) {
        this.user = user;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (user) {
                int v = (int) (System.currentTimeMillis() / 1000);
                user.setId(v);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                user.setName(String.valueOf(v));
            }
            Thread.yield();
        }
    }

    public static void main(String[] args) {
        ChangeObjectThread changeObjectThread = new ChangeObjectThread(new User());
        Thread thread = new Thread(changeObjectThread);
        thread.start();
        boolean haveLock = thread.holdsLock(changeObjectThread.user);
        System.err.println(haveLock);
    }
}

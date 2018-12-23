package com.sun.jvm.Jvm;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

/**
 * @ClassName SoftReFQ
 * @Despacito TODO
 * @Author chenzhuo
 * @Version 1.0
 * -Xmx10M -XX:+PrintGC
 * 没有回收引用
 *
 **/
public class SoftReFQ {
    public static class User {
        private int id;
        private String name;
        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    static ReferenceQueue<User> queue = null;

    public static class CheckReQueue extends Thread {
        public void run() {
            while (true) {
                if (queue != null) {
                    UserSoftRereence userSoftRereence = null;
                    try {
                    /*    System.out.println("userReferenceQueue:"+
                                userSoftRereence.get());*/
                        userSoftRereence = (UserSoftRereence) queue.remove();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (userSoftRereence != null) {
                        System.out.println("user id" +
                                userSoftRereence.userId + " is delete");
                    }
                }
            }
        }
    }

    /**
     * 强引用 不会回收
     * 软引用 比强引用弱一点，内存不足的时候就会被回收
     * 弱信用 回收,gc的时候发现就会回收
     * 虚引用 最弱
     */
    public static class UserSoftRereence extends SoftReference<User> {
        int userId;

        public UserSoftRereence(User referent, ReferenceQueue<? super User> queue) {
            super(referent);
            userId = referent.id;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new CheckReQueue();
        thread.setDaemon(true);
        thread.start();
        User user = new User(1,"chenzhuo");
        queue = new ReferenceQueue<>();
        UserSoftRereence userSoftRereence
                 = new UserSoftRereence(user,queue);
        user = null;
        System.out.println(userSoftRereence.get());
        System.gc();
        System.out.println("After GC:");
        System.out.println(userSoftRereence.get());
        System.out.println("尝试创建字节 和回收");
        byte[] b = new byte[7*1024*925];
        System.gc();
        System.out.println(userSoftRereence.get());
        Thread.sleep(1000);
    }

}

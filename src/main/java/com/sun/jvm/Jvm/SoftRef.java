package com.sun.jvm.Jvm;

import java.lang.ref.SoftReference;

/**
 * @ClassName SoftRef
 * @Despacito TODO
 * @Author chenzhuo
 * @Version 1.0
 **/
public class SoftRef {
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

    public static void main(String[] args) {
        User user = new User(1, "cz");
        SoftReference<User>
                userSoftReference = new SoftReference<>(user);
        user = null;

        System.out.println(userSoftReference.get());
        System.gc();
        System.out.println("After GC:");
        System.out.println(userSoftReference.get());

        byte[] b = new byte[7 * 1024 * 925];
        System.gc();
        System.out.println(userSoftReference.get());

    }
}

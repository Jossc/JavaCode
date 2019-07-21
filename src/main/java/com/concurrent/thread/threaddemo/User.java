package com.concurrent.thread.threaddemo;

/**
 * @ClassName User
 * @Author chenzhuo
 * @Version 1.0
 * @Date 2019-07-20 23:56
 **/
public class User {
    private int id;
    private String name;

    public User() {
        this.id = 0;
        this.name = "0";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

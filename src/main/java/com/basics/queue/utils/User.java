package com.basics.queue.utils;

/**
 * @PACKAGE_NAME: com.basics.queue.utils
 * @PROJECT_NAME: JavaCode
 * @Date: 2018/4/9
 * @author: chenzhuo
 * 必须实现  Comparable 接口
 * 要不报错
 */
public class User implements   Comparable<User>{
    private String userName ;
    private int age;

    public User(String userName, int age) {
        this.userName = userName;
        this.age = age;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int compareTo(User o) {
        return 0;
    }
}

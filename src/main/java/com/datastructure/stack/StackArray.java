package com.datastructure.stack;

/**
 * 栈数组
 * 用数组实现栈 先进出，后进先出
 *
 * @ClassName StackArray
 * @Author chenzhuo
 * @Version 1.0
 * @Date 2019/12/6 12:45 下午
 **/
public class StackArray {

    private volatile int count;

    private int len;

    private String[] arrays;


    public StackArray(int len) {
        this.len = len;
        this.arrays = new String[len];
        this.count = 0;
    }

    public boolean addElement(String value) {
        if (len == count) {
            return false;
        }
        arrays[count] = value;
        ++count;
        return true;
    }

    public String pop() {
        if (count == 0) {
            return null;
        }
        String value = arrays[count - 1];
        --count;
        return value;
    }

    public static void main(String[] args) {

    }
}

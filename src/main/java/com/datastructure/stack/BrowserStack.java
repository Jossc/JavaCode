package com.datastructure.stack;

/**
 * 用栈实现浏览器 前进后退功能
 *
 * @ClassName BrowserStack
 * @Author chenzhuo
 * @Version 1.0
 * @Date 2019/12/9 12:56 下午
 **/
public class BrowserStack {

    public static void main(String[] args) {
/*
        StackCapacityArray<String> old = new StackCapacityArray<String>();

        StackCapacityArray<String> newStack = new StackCapacityArray<String>();*/
    }


    /**
     * 上一步
     * 根据index判断是否由上一步
     * 如果有上一步就返回上一步的index
     * 如果没有就返回当前index
     *
     * @param index 索引标记
     */
    public String nextValue(int index, StackCapacityArray<String> old, StackCapacityArray<String> newStack) {
        if (index < 0) {
            throw new RuntimeException("index must greater than 0");
        }
        String nextValue = old.get(index - 1);
        newStack.addElement(nextValue);
        return nextValue;
    }


    /**
     * 下一步
     * 根据index 判断是否有下一步
     * 如果有下一步就返回下一步，
     * 如果没有就返回当前index
     *
     * @param index
     */
    public void pre(int index, StackCapacityArray<String> old, StackCapacityArray<String> newStack) {
        if (index < 0) {
            throw new RuntimeException("index must greater than 0");
        }
    }
}

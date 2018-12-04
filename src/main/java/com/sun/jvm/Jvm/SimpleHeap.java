package com.sun.jvm.Jvm;

/**
 * @ClassName SimpleHeap
 * @Despacito TODO
 * @Author chenzhuo
 * @Version 1.0
 * 1.在一个栈帧里至少要包含局部变量表，操作数栈，帧数据区几个部分
 *       堆                   方法区                  java栈
 *       s1实例 ------------ s1实现 ------------------ s1局部变量
 *       s2实例 -------------s2实现 ------------------ s2局部变量
 **/
public class SimpleHeap {
    private  int id;
    public SimpleHeap(int id){
        this.id =id;
    }
    public void show(){
        System.out.println("my Id is :" + id );
    }

    public static void main(String[] args) {
        SimpleHeap simpleHeap  = new SimpleHeap(1);
        SimpleHeap simpleHeap2 = new SimpleHeap(2);
        simpleHeap.show();
        simpleHeap2.show();
    }
}

package com.jvm.bytecode;

/**
 * @author by chenzhuo
 * @Description 局部变量表
 * @Date 2019/7/1 15:07
 **/
public class HelloLocalVariable {

    public void hello() {
        foo(1, "哈哈");
    }

    public void foo(int age, String name) {
        String temp = "A";
        int i = 123;
    }

    public static void main(String[] args) {
        new HelloLocalVariable().hello();
    }
}

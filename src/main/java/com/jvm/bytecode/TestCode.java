package com.jvm.bytecode;

/**
 * @ClassName TestCode
 * @Author chenzhuo
 * @Version 1.0
 * @Date 2019-07-31 22:49
 **/
public class TestCode {
    public int a = 3;

    static Integer si = 6;

    String s = "Hello word";

    public static void main(String[] args) {
        TestCode testCode = new TestCode();
        testCode.a = 8;
        si = 10;

    }

    private void test() {
        this.a = a;
    }

}

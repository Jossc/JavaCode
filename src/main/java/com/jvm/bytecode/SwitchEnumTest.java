package com.jvm.bytecode;

import static com.jvm.bytecode.TestOne.ONE;

/**
 * @author by chenzhuo
 * @Description 查看枚举
 * @Date 2019/7/1 17:59
 **/
public class SwitchEnumTest {
    public static void main(String[] args) {
        TestOne testOne = TestOne.ONE;
        switch (testOne) {
            case ONE:
                System.out.println("1");
                break;
            case TWO:
                System.out.println("2");
                break;
            default:
                break;
        }
    }
}

enum TestOne {
    ONE,
    TWO;
}

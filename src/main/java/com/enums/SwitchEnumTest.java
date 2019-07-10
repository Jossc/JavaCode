package com.enums;

/**
 * @author by chenzhuo
 * @Description
 * @Date 2019/7/8 16:55
 **/
public class SwitchEnumTest {
    public static void main(String[] args) {

        TestEnums testEnums = TestEnums.A;
        System.err.println(testEnums.ordinal());
        switch (testEnums) {
            default:
                break;
            case A:
                System.err.println("hello word");
                break;
            case H:
                System.err.println("hello word");
                break;
        }


    }
}

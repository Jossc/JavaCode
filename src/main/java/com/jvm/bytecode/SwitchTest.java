package com.jvm.bytecode;

/**
 * @author by chenzhuo
 * @Description
 * testSwitch断层的
 * 不会自动填充，它的键值都是经过排序的，
 * 在查找上可以采用二分查找的方式，时间复杂度为 O(log n)
 * Code:
 *        0: iload_1
 *        1: lookupswitch  { // 3
 *                    100: 36
 *                    103: 38
 *                    105: 40
 *                default: 42
 *           }
 *
 * testSwitchOne 非断层的
 * 会自动填充，根据游标查找，时间复杂度为O(1)
 *  Code:
 *        0: iload_1
 *        1: tableswitch   { // 100 to 104
 *                    100: 36
 *                    101: 38
 *                    102: 42
 *                    103: 42
 *                    104: 40
 *                default: 42
 *           }
 *
 *
 * @Date 2019/7/1 17:43
 **/
public class SwitchTest {

    public static void main(String[] args) {
        new SwitchTest().testSwitch(100);
    }

    int testSwitchOne(int i) {
        switch (i) {
            case 100:
                return 1;
            case 101:
                return 2;
            case 104:
                return 4;
            default:
                return 0;
        }
    }

    int testSwitch(int i) {
        switch (i) {
            case 100:
                return 1;
            case 103:
                return 2;
            case 105:
                return 4;
            default:
                return 0;
        }
    }


}

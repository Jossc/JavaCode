package com.basics.ThreadCode.LockSUpport;

import java.util.concurrent.locks.LockSupport;

/**
 * @ClassName LockSupportTestTwo
 * @Description TODO
 * @Author chenzhuo
 * @Date 2018/8/15 15:42
 * @Version 1.
 * LockSupport 测试 查看pid
 **/
public class LockSupportTestTwo {
    public static void main(String[] args) {
        LockSupportTestTwo testTwo = new LockSupportTestTwo();
        testTwo.parkTest();
    }

    public void parkTest(){
        LockSupport.park(this);
    }
}

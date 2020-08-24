package com.jvm.gc;

import javax.xml.crypto.Data;

/**
 * 测试分代担保机制
 *
 * @author 一方通行
 * @title: TestHandlePromotionFailure
 * @projectName JavaCode
 * @date 2020/8/22 18:50
 */
public class TestHandlePromotionFailure {
    private static final int DEF_MB = 1024 * 1024;

    public static void testHandlePromotion() {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[2 * DEF_MB];
        allocation2 = new byte[2 * DEF_MB];
        allocation3 = new byte[2 * DEF_MB];
        allocation4 = new byte[4 * DEF_MB];
    }

    public static void main(String[] args) {
        testHandlePromotion();
    }

}

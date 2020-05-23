package com.performance.cpu;

import java.util.Date;

/**
 * @description: 缓存效率测试
 * @author: Crazy
 * @date: 2020/5/19 22:10
 */
public class CacheArrayListTest {

    public static int TESTN = 4096;

    public static void main(String[] args) {
        new CacheArrayListTest().testArray();
        new CacheArrayListTest().testArrayContinuity();
    }

    /**
     * 连续的数组访问
     */
    public void testArrayContinuity() {
        Date start = new Date();
        char[][] arr = new char[TESTN][TESTN];
        for (int i = 0; i < TESTN; i++) {
            for (int j = 0; j < TESTN; j++) {
                //i j 是连续访问
                arr[i][j] = 0;
            }
        }
        System.out.println(new Date().getTime() - start.getTime());
    }

    /**
     * 非连续数组访问
     */
    public void testArray() {
        Date start = new Date();
        char[][] arr = new char[TESTN][TESTN];
        for (int i = 0; i < TESTN; i++) {
            for (int j = 0; j < TESTN; j++) {
                //J i是非连续访问
                arr[j][i] = 0;
            }
        }
        System.out.println(new Date().getTime() - start.getTime());

    }
}

package com.performance.cpu;

import java.util.Date;
import java.util.Random;

import static java.util.Arrays.sort;

/**
 * @description: 有一个元素为 0 到 255 之间随机数字组成的数组
 * 一是循环遍历数组，判断每个数字是否小于 128，如果小于则把元素的值置为 0；
 * 二是将数组排序
 * @author: Crazy
 * @date: 2020/5/19 22:36
 */
public class CacheArrayListTest2 {

    public static int arrayLength = 255;

    public static void main(String[] args) {
        new CacheArrayListTest2().eachSort();
        new CacheArrayListTest2().sortEach();
    }

    public void eachSort() {
        Date start = new Date();
        int array[] = new int[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            array[i] = new Random().nextInt(256);
        }
        sort(array);
        for (int i = 0; i < 255; i++) {
            if (array[i] < 128) array[i] = 0;
        }
        System.out.println(new Date().getTime() - start.getTime());
    }

    public void sortEach() {
        Date start = new Date();
        int array[] = new int[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            array[i] = new Random().nextInt(256);
        }
        for (int i = 0; i < 255; i++) {
            if (array[i] < 128) array[i] = 0;
        }
        sort(array);
        System.out.println(new Date().getTime() - start.getTime());
    }
}

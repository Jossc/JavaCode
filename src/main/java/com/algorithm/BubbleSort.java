package com.algorithm;

import java.util.Arrays;

/**
 * @ClassName BubbleSort
 * @Author chenzhuo
 * @Version 1.0
 * @Date 2019-08-17 21:47
 **/
public class BubbleSort {

    public static void main(String[] args) {
        int[] array = new int[]{5, 8, 6, 3, 9, 2, 1, 7};
        sort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void sort(int[] array) {
        int tmp = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
    }

    public static void sort2(int[] array) {
        int tmp = 0;
        for (int i = 0; i < array.length; i++) {
            boolean isSorted = true;
            for (int j = 0; j < array.length - i - 1; j++) {

            }
        }
    }
}

package com.algorithm;

import java.util.Arrays;
import java.util.Random;

/**
 * @ClassName QuickSort
 * @Author chenzhuo
 * @Version 1.0
 * @Date 2019-08-18 20:06
 **/
public class QuickSort {

    public static void main(String[] args) {
        int[] a = new int[10];
        for (int i = 0; i < a.length; i++) {
            Random random = new Random();
            a[i] = random.nextInt(100);
        }
        quickSort(a, 0, a.length - 1);
        System.err.println(Arrays.toString(a));
    }


    public static void quickSort(int[] a, int low, int high) {
        int pivot;
        if (low < high) {
            pivot = partition(a, low, high);
            quickSort(a, low, pivot - 1);
            quickSort(a, pivot + 1, high);

        }
    }

    public static int partition(int[] a, int low, int high) {
        int pivokey = a[low];
        while (low < high) {
            while (high > low && a[high] >= pivokey) {
                high--;
            }
            a[low] = a[high];
            while (high > low && a[low] <= pivokey) {
                low++;
            }
            a[high] = a[low];
        }
        a[low] = pivokey;
        return low;
    }

}

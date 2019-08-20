package com.algorithm;


import java.util.Arrays;

/**
 * @CLassName MergingTwo
 * @Author chenzhuo
 * @Version 1.0
 * @Date 2019-08-17 22:37
 **/
public class MergingTwo {


    /**
     * 分割数组
     * 按照
     * 0+数组长度来分割
     *
     * @param agrrays
     * @param L
     * @param r
     */
    public static void mergeSort(int[] agrrays, int L, int r) {
        if (L == r) {
            return;
        } else {
            int M = (L + r) / 2;
            mergeSort(agrrays, L, M);
            mergeSort(agrrays, M + 1, r);
            merge(agrrays, L, M + 1, r);
        }
    }

    /**
     * 合并结果
     *
     * @param arrays
     * @param L
     * @param m
     * @param r
     */
    public static void merge(int[] arrays, int L, int m, int r) {
        //这里不能用m-l+1 因为下边的变量j 在右边的数组中可能会越界
        int[] left = new int[m - L];

        int[] righ = new int[r - m + 1];

        for (int i = L; i < m; i++) {
            left[i - L] = arrays[i];
        }
        for (int i = m; i <= r; i++) {
            righ[i - m] = arrays[i];
        }
        int i = 0, j = 0;
        int k = L;
        //比较这两个数组的值，哪个小，就往数组上放
        while (i < left.length && j < righ.length) {
            //谁比较小，谁将元素放入大数组中,移动指针，继续比较下一个
            if (left[i] < righ[j]) {
                arrays[k] = left[i];
                i++;
                k++;
            } else {
                arrays[k] = righ[j];
                j++;
                k++;
            }
        }
        //如果左边的数组还没比较完，右边的数都已经完了，那么将左边的数抄到大数组中(剩下的都是大数字)
        while (i < left.length) {
            arrays[k] = left[i];
            i++;
            k++;
        }
        //如果右边的数组还没比较完，左边的数都已经完了，那么将右边的数抄到大数组中(剩下的都是大数字)
        while (j < righ.length) {
            arrays[k] = righ[j];
            k++;
            j++;
        }

    }

    public static void main(String[] args) {
        int[] arrays = {-340, 2, 5, 1, 3, 30, 60, 5, 2, 1, 8};
        mergeSort(arrays, 0, arrays.length - 1);
        System.err.println(Arrays.toString(arrays));
    }
}

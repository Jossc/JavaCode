package com.algorithm;

/**
 * @ClassName Merging
 * @Author chenzhuo
 * @Version 1.0
 * @Date 2019-08-17 14:39
 **/
public class Merging {

    /**
     * 排序
     *
     * @param array 数字
     * @param low   低
     * @param high  高
     * @return
     */
    public static int[] sort(int[] array, int low, int high) {
        int mind = (low + high) / 2;
        if (low < high) {
            sort(array, low, mind);
            sort(array, mind + 1, high);

        }
        return array;
    }

    /**
     * 合并
     *
     * @param array 数组
     * @param low   最低
     * @param high  最高
     */
    public static void merge(int[] array, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int k = 0;

        while (i < mid && j <= high) {
            if (array[i] <= array[j]) {
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
            }
        }
        // 把左边剩余的数移入数组
        while (i <= mid) {
            temp[k++] = array[i++];
        }
        // 把右边边剩余的数移入数组
        while (j <= high) {
            temp[k++] = array[j++];
        }
        // 把新数组中的数覆盖nums数组
        for (int x = 0; x < temp.length; x++) {
            array[x + low] = temp[x];
        }
    }
}

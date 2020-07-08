package com.evething;

/**
 * @author Hikari
 * @version 1.0.0
 * @ClassName SolutionTest.java
 * @createTime 2020年07月08日 15:32:00
 */
public class SolutionTest {

    public static void main(String[] args) {
        int[] arr = {1, 4, 23, 2, 6, 9, 13, 5, 45, 12};
        int k = 3;
        System.out.println(new SolutionTest().findKth(arr, k));
    }

    public int findKth(int[] arr, int k) {
        if (k == 0) {
            return 0;
        }
        // 统计每个数字出现的次数
        int[] counter = new int[10000];
        for (int num : arr) {
            counter[num] = counter[num] + 1;
        }
        int x = 0;
        // 遍历 counter，查找第 k 小的奇数
        for (int num = 0; num < counter.length; num++) {
            if (counter[num] > 0 && x < k && num % 2 == 1) {
                x++;
            }
            if (x == k) {
                return num;
            }
        }
        return 0;
    }
}

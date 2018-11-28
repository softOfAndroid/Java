package com.zxy.datastruct.array;

import java.util.Arrays;

/**
 * 合并2个排序好的数组
 */
public class 合并2个排序好的数组 {

    public static void main(String[] args) {
        int[] arr1 = new int[]{2, 3, 5, 6, 7, 10};
        int[] arr2 = new int[]{1, 4, 8, 9, 11};
        int[] arr3 = mergeArray(arr1, arr2);
        System.out.println(Arrays.toString(arr3));
    }

    public static int[] mergeArray(int[] arr1, int[] arr2) {
        int n1 = arr1.length;
        int n2 = arr2.length;
        int[] arr3 = new int[n1 + n2];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < n1 && j < n2) {
            if (arr1[i] < arr2[j]) {
                arr3[k++] = arr1[i++];
            } else {
                arr3[k++] = arr2[j++];
            }
        }
        while (i < n1) {
            arr3[k++] = arr1[i++];
        }
        while (j < n2) {
            arr3[k++] = arr2[j++];
        }
        return arr3;
    }
}

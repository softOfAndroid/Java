package com.zxy.datastruct.array;

import java.util.Arrays;

/**
 * 查找数组中最小的和第二小的数
 */
public class 数组中最小的和第二小的数 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findSmallestAndSecondSmallest(new int[]{3, 5, 2, 1, 6, 7, 4, 8, 1})));
    }

    public static int[] findSmallestAndSecondSmallest(int[] nums) {
        // 3,5,2,1,6,7,4,8,1
        if (nums.length < 2) {
            return new int[0];
        }
        int smallest = nums[0];
        int secondSmallest = nums[1];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < smallest) {
                secondSmallest = smallest;
                smallest = nums[i];
            } else if (nums[i] < secondSmallest && nums[i] != smallest) {
                secondSmallest = nums[i];
            }
        }
        return new int[]{smallest, secondSmallest};
    }
}

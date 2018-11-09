package com.zxy.datastruct.array;

/**
 * 查找第一个没有重复的数组元素
 */
public class 第一个没有重复的数组元素 {
    public static void main(String[] args) {
        System.out.println(firstNotRepeat(new int[]{3, 1, 8, 5, 3, 6}));
    }

    public static int firstNotRepeat(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    break;
                }
                if (j == nums.length - 1 && nums[i] != nums[j]) {
                    return nums[i];
                }
            }
        }
        return 0;
    }
}

package com.zxy.datastruct.array;

/**
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水
 * <p>
 * des:你不能倾斜容器，且 n 的值至少为 2。
 */
public class 盛最多水的容器 {
    public static void main(String[] args) {
        //[1,8,6,2,5,4,8,3,7]=== 49
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

    /**
     * 较优算法;时间复杂度O(n)
     *
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        if (height.length < 2) {
            return 0;
        }
        int leftIndex = 0;
        int rightIndex = height.length - 1;
        int aear = 0;
        while (leftIndex < rightIndex) {
            aear = Math.max(aear, (rightIndex - leftIndex) * Math.min(height[leftIndex], height[rightIndex]));
            if (height[leftIndex] < height[rightIndex]) {
                leftIndex++;
            } else {
                rightIndex--;
            }
        }
        return aear;
    }

    /**
     * 时间复杂度O(n * n)
     *
     * @param height
     * @return
     */
    public int maxArea1(int[] height) {
        int miner;
        int target = 0;
        if (height.length < 2) {
            return 0;
        }
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                miner = height[i] <= height[j] ? height[i] : height[j];
                if ((j - i) * miner > target) {
                    target = (j - i) * miner;
                }

            }
        }
        return target;
    }
}

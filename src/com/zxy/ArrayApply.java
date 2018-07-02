package com.zxy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 数组:具有相同类型的若干元素按无序的形式排列的固定大小的数据元素集合叫做数组
 * 1. 定义
 * 2. 插入
 * 3. 刪除
 * 4. 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数
 */
public class ArrayApply {
    /**
     * 1. 声明定义(3种方式)
     */
    public static void defineArray() {
        int[] arr1 = new int[]{3, 7, 1, 5, 9, 6, 2};
        int[] arr2 = {3, 7, 1, 5, 9, 6, 2};
        int[] arr3 = new int[7];
        arr3[0] = 3;
        arr3[1] = 7;
        arr3[2] = 1;
        arr3[3] = 5;
        arr3[4] = 9;
        arr3[5] = 6;
        //arr3[6] 没有复制则为 0;
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(arr3));
    }

    /**
     * 2.插入   将8插入到数组第三个位置上
     */
    public static void insertArray() {
        int[] arr = new int[]{3, 7, 1, 5, 9, 6, 2};
        int a = 8;
        int[] newarr = new int[arr.length + 1];
        for (int i = 0; i < newarr.length; i++) {
            if (i == 3) {
                newarr[i] = a;
            } else if (i < 3) {
                newarr[i] = arr[i];
            } else if (i > 3) {
                newarr[i] = arr[i - 1];
            }
        }
        System.out.println("插入的数组为：" + Arrays.toString(newarr));
    }

    /**
     * 3.删除 将第三个位置的元素 8 删除
     */
    public static void deleteArray() {
        int[] newarr = new int[]{3, 7, 1, 8, 5, 9, 6, 2};
        for (int i = 0; i < newarr.length; i++) {
            if (i > 3) {
                newarr[i - 1] = newarr[i];
            }
        }
        newarr = Arrays.copyOf(newarr, newarr.length - 1);
        System.out.println("删除的数组为：" + Arrays.toString(newarr));
    }

    /**
     * 4.两数之和等于目标数
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int value = target - nums[i];
            if (map.containsKey(value)) {
                return new int[]{map.get(value), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
//        insertArray();
//        deleteArray();
        System.out.println(Arrays.toString(twoSum(new int[]{1, 3, 5, 8, 9}, 10)));
    }

}

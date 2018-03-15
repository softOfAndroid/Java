package com.zxy;

import java.util.Arrays;

/**
 * 数组
 * 1.解释：具有相同类型的若干元素按无序的形式排列的固定大小的数据元素集合叫做数组
 * 2.如果存放
 * 3.占用空间大小
 * 4.查找、插入、移除
 */
public class ArrayApply {

	public static void main(String[] args) {
		/**
		 *  1. 声明定义(3种方式)
		 */
		int[] arr1 = new int[]{3,7,1,5,9,6,2};
		
		int[] arr2 = {3,7,1,5,9,6,2};
		
		int[] arr3 = new int[7];
		arr3[0]=3;
		arr3[1]=7;
		arr3[2]=1;
		arr3[3]=5;
		arr3[4]=9;
		arr3[5]=6;
		//arr3[6] 没有复制则为 0;
		
		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.toString(arr2));
		System.out.println(Arrays.toString(arr3));
		
		/**
		 *  2. 如何存放的
		 *  arr1、arr2、arr3 变量存储在栈内存中
		 *  {3,7,1,5,9,6,2} 存放在堆内存中
		 */
		
		/**
		 * 3.查找
		 */
		System.out.println(arr1[2] + "," + arr1[3]);
		
		/**
		 * 4.插入   将8插入到数组第三个位置上
		 */
		int a = 8;
		int[] newarr1 = new int[arr1.length + 1];
		for (int i = 0; i < newarr1.length; i++) {
			if (i == 3) {
				newarr1[i] = a;
			}else if(i < 3){
				newarr1[i] = arr1[i];
			}else if(i>3){
				newarr1[i] = arr1[i -1];
			}
		}
		System.out.println("插入的数组为：" + Arrays.toString(newarr1));
		/**
		 * 5.删除 将第三个位置的元素 8 删除
		 */
		for (int i = 0; i < newarr1.length; i++) {
			if (i > 3) {
				newarr1[i-1] = newarr1[i];
			}
		}
		newarr1 = Arrays.copyOf(newarr1, newarr1.length - 1);
		System.out.println("删除的数组为：" + Arrays.toString(newarr1));
	}

}

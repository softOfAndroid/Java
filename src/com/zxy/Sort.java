package com.zxy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 排序
 * 
 * @author zxy 2017年6月29日
 */
public class Sort {

	public static void main(String[] args) {
		List<int[]> list = new ArrayList<>();
		for (int i = 0; i < 6; i++) {
			list.add(new int[]{49, 38, 65, 76, 13, 27, 34, 12, 64, 5, 4, 62, 54, 17, 12, 23, 1});
		}
		// 冒泡排序
		bubbleSort(list.get(0));
		// 插入排序
		insertSort(list.get(1));
		// 希尔排序
		shellSort(list.get(2));
		// 选择排序
		selectSort(list.get(3));
		// 堆排序
		heapSort(list.get(4));
		// 快速排序
		quickSort(list.get(5));
	}

	/**
	 * 冒泡排序:每当两相邻的数比较后发现它们的排序与排序要求相反时，就将它们互换
	 * 
	 * @param array
	 */
	private static void bubbleSort(int[] array) {
		int temp = 0;
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = 0; j < array.length - i - 1; j++) {
				if (array[j] > array[j + 1]) {
					temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
		System.out.println("冒泡排序:" + Arrays.toString(array));
	}

	/**
	 * 插入排序：插入排序就是把当前待排序的元素插入到一个已经排好序的列表里面
	 * 
	 * @param array
	 */
	private static void insertSort(int[] array) {
		int insertTarget;
		for (int i = 1; i < array.length; i++) {
			int position = i;
			insertTarget = array[i];
			while (position > 0 && insertTarget < array[position - 1]) {
				array[position] = array[position - 1];
				position--;
			}
			array[position] = insertTarget;
		}
		System.out.println("插入排序:" + Arrays.toString(array));
	}
	

	/**
	 * 希尔排序：也称递减增量排序算法，是插入排序的一种更高效的改进版本
	 * @param
	 */
	private static void shellSort(int[] data) {
		int j = 0;
		int k = data.length / 2;
		// 每次将步长缩短为原来的一半
		while (k > 0) {
			for (int i = k; i < data.length; i++) {
				int temp = data[i];
				for (j = i; j >= k; j = j - k) {
					if (temp < data[j - k]) {
						data[i] = data[j - k];
					} else {
						break;
					}
				}
				data[j] = temp;
			}
			k /= 2;
		}
		System.out.println("希尔排序:" + Arrays.toString(data));
	}

	/**
	 * 选择排序：在要排序的一组数中，选出最小的一个数与第一个位置的数交换；
	 * 
	 * 然后在剩下的数当中再找最小的与第二个位置的数交换，如此循环
	 * 
	 * @param array
	 */
	private static void selectSort(int[] array) {
		for (int i = 0; i < array.length; i++) {
			int position = i;
			// 标记最小位置
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] < array[position]) {
					position = j;
				}
			}
			if (i != position) {
				int temp = array[i];
				array[i] = array[position];
				array[position] = temp;
			}
		}
		System.out.println("选择排序:" + Arrays.toString(array));
	}

	/**
	 * 堆排序：堆排序是一种树形选择排序，是对直接选择排序的有效改进
	 * 
	 * @param array
	 */
	private static void heapSort(int[] array) {

		
	}

	/**
	 * 快速排序：选择一个基准元素,通常选择第一个元素或者最后一个元素,通过一趟扫描，将待排序列分成两部分,
	 * 
	 * 一部分比基准元素小,一部分大于等于基准元素, 此时基准元素在其排好序后的正确位置,
	 * 
	 * 然后再用同样的方法递归地排序划分的两部分
	 * 
	 * @param array
	 */
	private static void quickSort(int[] array) {
		quickSort(array, 0, array.length - 1);
		System.out.println("快速排序:" + Arrays.toString(array));
	}
	
	private static void quickSort(int[] array, int low, int high){
		if (low < high) {
			int middle = getMiddle(array, low, high);
			quickSort(array, low, middle - 1);
			quickSort(array, middle + 1, high);
		}
		}
	
	private static int getMiddle(int[] array,int low,int high){
		int temp = array[low];
		while (low < high) {
			while (low < high && array[high] >= temp){
				high -- ;
			}
			array[low] = array[high];
			
			while (low < high && array[low] <= temp) {
				low ++ ;
			}
			array[high] = array[low];
		}
		array[low] = temp;
		return low;
	}
}

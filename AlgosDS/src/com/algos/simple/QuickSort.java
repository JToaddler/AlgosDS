package com.algos.simple;

import java.util.Arrays;

/**
 * 
 * https://www.geeksforgeeks.org/quick-sort/
 * 
 * https://www.youtube.com/watch?v=MZaf_9IZCrc
 * 
 * @author Anto
 *
 */
public class QuickSort {

	public static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public static int partion(int[] array, int low, int high) {
		int i = low - 1;
		int pivot = array[high];
		for (int j = low; j < high; j++) {
			if (array[j] < pivot) {
				i++;
				swap(array, i, j);
			}
		}
		swap(array, i + 1, high);
		return i + 1;
	}

	public static void quickSort(int[] array, int low, int high) {
		if (low < high) {
			int pivot = partion(array, low, high);
			quickSort(array, low, pivot - 1);
			quickSort(array, pivot + 1, high);
		}
	}

	public static void main(String[] args) {

		int[] array = new int[] { 10, 7, 8, 9, 1, 5 };
		System.out.println(Arrays.toString(array));
		quickSort(array, 0, array.length - 1);
		System.out.println(Arrays.toString(array));
	}

}

package com.algos.sort;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * <p>
 * <code>
 * Now , calculating total number of comparison required to sort the array
= (n-1) + (n-2) +  (n-3) + . . . 2 + 1
= (n-1)*(n-1+1)/2  { by using sum of N natural Number formula }
=  n (n-1)/2    
 * 
 * Total swaps required = (n * (n-1)) 2
 * </code>
 * </p>
 * 
 * Time complexity = O(N^2) (worst case when array is reverse sorted) O(N) when
 * array is sorted Space complexity = O(1)
 * 
 * @author Anto
 *
 */
public class BubbleSort {

	public static void main(String[] args) {
		int[] array = generateArray(10);
		bubbleSort(array);
	}

	public static void bubbleSort(int[] array) {

		int n = array.length;
		for (int i = 0; i < n - 1; i++) {
			boolean swapped = false;
			for (int j = 0; j < n - 1 - i; j++) {
				if (array[j] > array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
					swapped = true;
				}
			}
			if (swapped == false)
				break;
		}
		System.out.println("Sorted Array :" + Arrays.toString(array));
	}

	public static int[] generateArray(int n) {
		int[] array = new int[n];
		IntStream.range(0, n).forEach(item -> array[item] = (int) (Math.random() * 100));
		System.out.println(Arrays.toString(array));
		return array;
	}

}

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

	public static void bubbleSort(int[] nums) {

		boolean swapped = true;
		while (swapped) {
			swapped = false;
			for (int i = 0; i < nums.length - 1; i++) {
				if (nums[i] > nums[i + 1]) {
					int temp = nums[i + 1];
					nums[i + 1] = nums[i];
					nums[i] = temp;
					swapped = true;
				}
			}
		}
		System.out.println("Sorted Array :" + Arrays.toString(nums));
	}

	public static int[] generateArray(int n) {
		int[] array = new int[n];
		IntStream.range(0, n).forEach(item -> array[item] = (int) (Math.random() * 100));
		System.out.println(Arrays.toString(array));
		return array;
	}

}

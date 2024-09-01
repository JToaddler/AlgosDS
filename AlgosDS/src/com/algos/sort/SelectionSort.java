package com.algos.sort;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * https://www.geeksforgeeks.org/selection-sort-algorithm-2/
 * 
 * Complexity Analysis of Selection Sort Time Complexity: The time complexity of
 * Selection Sort is O(N2) as there are two nested loops:
 * 
 * One loop to select an element of Array one by one = O(N) Another loop to
 * compare that element with every other Array element = O(N) Therefore overall
 * complexity = O(N) * O(N) = O(N*N) = O(N2)
 * 
 * Space complexity : O(1) as the only extra memory used is for temporary
 * variables while swapping two values in Array.
 * 
 * @author Anto
 *
 */
public class SelectionSort {

	public static void main(String[] args) {

		int[] arr = IntStream.range(1, 10).map(a -> (int) Math.round(Math.random() * 100)).toArray();
		System.out.println(Math.round(Math.random() * 100));
		selectionSort(arr);
	}

	public static void selectionSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int minIndex = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[minIndex]) {
					minIndex = j;
				}
			}
			int temp = arr[minIndex];
			arr[minIndex] = arr[i];
			arr[i] = temp;
		}
		System.out.println("Sorted Array :" + Arrays.toString(arr));
	}

}

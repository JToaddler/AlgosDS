package com.algos.sort;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * 
 * 
 * The worst case time complexity of Insertion sort is O(N^2) The average case
 * time complexity of Insertion sort is O(N^2) The time complexity of the best
 * case is O(N).
 * 
 * 
 * 
 * The auxiliary space complexity of Insertion Sort’s Recursive Approach is O(n)
 * due to the recursion stack.
 * 
 * 
 * 
 * 
 * 
 * @author Anto
 *
 */
public class InsertionSort {

	public static void main(String[] args) {

		int max = 5;
		Long[] array = new Long[max];
		IntStream.range(0, max).forEach(index -> {
			array[index] = Math.round(Math.random() * 1000);
		});
		System.out.println(Arrays.asList(array));
		// Arrays.sort(array);
		sort(array);
		System.out.println(Arrays.asList(array));
	}

	static void sort(Long arr[]) {
		for (int i = 1; i < arr.length; i++) {
			long a = arr[i - 1];
			long b = arr[i];
			if (a > b) {
				arr[i] = a;
				arr[i - 1] = b;
			}
			int m = i;
			while (m > 0) {
				long c = arr[m - 1];
				long d = arr[m];
				if (c > d) {
					arr[m - 1] = d;
					arr[m] = c;
				}
				m--;
			}
		}
	}
}
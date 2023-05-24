package com.ds.heap;

/**
 * 
 * https://www.geeksforgeeks.org/maximum-element-in-min-heap/ - is wrong
 * 
 * 
 * step 1 : identify the last non-leaf node. [ (n/2)-1 where n is total number of
 * nodes]
 * 
 * step 2 : start comparing the first element ;
 * 
 * @author Anto
 *
 */
public class MaxElementInMinHeap {

	public static int findMaxinMinHeap(int[] nums, int total) {
		int max = nums[0];
		for (int i = (total / 2); i < total; i++) { // last non leaf node = n / 2 - 1 , first leaf node = last non lead
													// node + 1 =>
			max = Math.max(max, nums[i]);
		}
		System.out.println(" Max in MinHeap :" + max);
		return max;
	}

	public static void main(String[] args) {

		// int n = 10;
		// int[] heap = { 10, 25, 23, 45, 50, 81, 30, 63, 65, 35 };

		int n = 4;
		int[] heap = { 10, 25, 23, 45 };

		findMaxinMinHeap(heap, n);

	}

}

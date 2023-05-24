package com.ds.heap;

/**
 * 
 * https://www.geeksforgeeks.org/minimum-element-in-a-max-heap/
 * 
 * Last Non-leaf Node = (n/2) – 1 
 * First Lead Node = Last Non leaf node +1  =>  n/2 
 * Start the iteration from First lead node.
 * 
 * @author Anto
 *
 */
public class MinElementInMaxHeap {

	public static int findMininMaxHeap(int[] nums, int total) {
		int min = nums[0];
		for (int i = total / 2; i < total; i++) {
			min = Math.min(min, nums[i]);
		}
		System.out.println(" Min in Max Heap :" + min);
		return min;
	}

	public static void main(String[] args) {

		int n = 10;
		int heap[] = { 20, 18, 10, 12, 9, 9, 3, 5, 6, 8 };
		findMininMaxHeap(heap, n);
	}
}

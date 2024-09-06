package com.algos.sort;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * 
 * Step 1: find the min & max
 * 
 * 
 */
public class CountingSort {

	public static void main(String[] args) {
		// int[] nums = IntStream.rangeClosed(1, 6).map(a -> (int)
		// Math.round(Math.random() * 10)).toArray();
		int[] nums = { 5, 4, 5, 5, 1, 1, 3 };
		System.out.println(Arrays.toString(nums));
		countingSort(nums);

	}

	public static void countingSort(int[] nums) {
		int max = Arrays.stream(nums).max().getAsInt();
		int[] counts = new int[max + 1];

		for (int e : nums) {
			counts[e] += 1;
		}

		System.out.println(Arrays.toString(counts));
		int startingIndex = 0;
		for (int i = 0; i < max + 1; i++) {
			int c = counts[i];
			counts[i] = startingIndex;
			startingIndex += c;
		}
		System.out.println(Arrays.toString(counts));
		int[] sorted = new int[nums.length];
		for (int ele : nums) {
			sorted[counts[ele]] = ele;
			counts[ele] += 1;
		}
		System.out.println(Arrays.toString(sorted));
	}

}

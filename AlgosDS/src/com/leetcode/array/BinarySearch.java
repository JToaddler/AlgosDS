package com.leetcode.array;

import java.util.Arrays;

/**
 * 
 * https://www.geeksforgeeks.org/binary-search/
 * 
 * time complexity - O(log n)
 * 
 * @author Anto
 *
 */
public class BinarySearch {

	public static int binarySearch(int[] nums, int target) {

		if (nums == null || nums.length == 0) {
			return -1;
		}
		Arrays.sort(nums);
		int l = 0;
		int r = nums.length - 1;
		while (l <= r) {
			int mid = r + l / 2;
			if (nums[mid] == target) {
				return mid;
			}
			if (nums[mid] < target) {
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
		return -1;

	}

	public static void main(String[] args) {

		int[] test1Array = new int[] { 3, 8, 2, 9, 1, 5, 4, 51, 78, 89, 234, 56, 78, 67, 89, 90, 256, 831, 679, 8989,
				435, 34, 23, 67, 89 };

		System.out.println(binarySearch(test1Array, 56));

	}

}

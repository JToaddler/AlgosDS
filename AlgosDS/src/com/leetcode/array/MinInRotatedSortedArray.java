package com.leetcode.array;

/**
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array
 * 
 * @author Anto
 *
 */
public class MinInRotatedSortedArray {

	public static Integer findMin(int[] nums) {

		if (nums.length == 1) {
			return nums[0];
		}
		if (nums.length == 2) {
			if (nums[0] > nums[1]) {
				return nums[1];
			}
		}

		int left = 0;
		int right = nums.length - 1;
		while (left <= right) {
			int mid = right + (left - right) / 2;

			if (nums[mid] > nums[mid + 1]) {
				return nums[mid + 1];
			}
			if (nums[mid] < nums[mid - 1]) {
				return nums[mid];
			}
			
			// below is for identifying the next mid point for divide and conquer
			if (nums[left] < nums[mid]) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return null;
	}

	public static void main(String[] args) {

		System.out.println(findMin(new int[] { 4, 5, 6, 7, 8, 1, 2, 3 }));

	}

}

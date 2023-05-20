package com.leetcode.array;

public class SingleElementInSortedArray {

	public static Integer findSingleElment(int[] nums) {

		int left = 0;
		int right = nums.length - 1;
		while (left < right) {
			int mid = right + (left - right) / 2;
			if (mid % 2 == 1) {
				mid = mid - 1;
			}
			if (nums[mid] != nums[mid + 1]) {
				right = mid;
			} else {
				left = mid + 2;
			}
		}
		return nums[left];
	}

	public static void main(String[] args) {
		System.out.println(findSingleElment(new int[] { 1, 1, 2, 3, 3 }));
	}

}

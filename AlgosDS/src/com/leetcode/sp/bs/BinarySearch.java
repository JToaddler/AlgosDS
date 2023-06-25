package com.leetcode.sp.bs;

public class BinarySearch {

	public static void main(String[] args) {
		System.out.println(search(new int[] { -1, 0, 3, 5, 9, 12 }, 9));
	}

	public static int search(int[] nums, int target) {
		int left = 0, right = nums.length - 1;
		while (left <= right) {
			int mid = (right + left) / 2;
			if (nums[mid] == target)
				return mid;
			if (target > nums[mid])
				left = mid + 1;
			else
				right = mid - 1;
		}
		return -1;
	}

}

package com.leetcode.sp.bs;

public class SearchRange {
	public static void main(String[] args) {
		int[] nums = { 1, 2, 2, 2, 2, 3 };
		int left = searchRange(nums, 4, true);
		int right = searchRange(nums, 4, false);
		System.out.println(left + " " + right);
	}

	public static int searchRange(int[] nums, int target, boolean leftBias) {
		int left = 0, right = nums.length - 1;
		int index = -1;
		while (left <= right) {
			int mid = right + (left - right) / 2;
			if (nums[mid] > target)
				right = mid - 1;
			else if (nums[mid] < target)
				left = mid + 1;
			else {
				index = mid;
				if (leftBias)
					right = mid - 1;
				else
					left = mid + 1;
			}
		}
		return index;
	}

}

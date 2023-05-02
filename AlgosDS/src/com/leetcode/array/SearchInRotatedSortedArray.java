package com.leetcode.array;

/**
 * 
 * This is a modified binary search.
 * 
 * https://leetcode.com/problems/search-in-rotated-sorted-array
 * 
 * 
 * @author Anto
 *
 */
public class SearchInRotatedSortedArray {

	public static int search(int[] nums, int target) {
		if (nums == null || nums.length == -0) {
			return -1;
		}
		int l = 0;
		int r = nums.length - 1;
		while (l <= r) {
			int mid = r + (l - r) / 2;
			if (nums[mid] == target) {
				return mid;
			}
			if (nums[l] <= nums[mid]) { // left half is sorted array
				if (target >= nums[l] && target <= nums[mid]) {
					r = mid - 1;
				} else {
					l = mid + 1;
				}
			} else { // right half is sorted array
				if (target >= nums[mid] && target <= nums[r]) {
					l = mid + 1;
				} else {
					r = mid - 1;
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] nums = new int[] { 4, 5, 6, 7, 8, 0, 1, 2, 3 };
		System.out.println(search(nums, 2));
	}

}

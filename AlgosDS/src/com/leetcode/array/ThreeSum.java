package com.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {

	/**
	 * https://leetcode.com/problems/3sum/description/
	 * 
	 * https://leetcode.com/problems/3sum/solutions/3109452/c-easiest-beginner-friendly-sol-set-two-pointer-approach-o-n-2-logn-time-and-o-n-space/
	 * 
	 * Time complexity: O(n^2 log n) - where n is the size of array
	 * 
	 * Sorting takes O(n log n) time and loop takes O(n^2) time, So the overall time
	 * complexity is O(n log n + n^2 log n) - O(n^2 log n)
	 * 
	 * 
	 * Space complexity: O(n) - for taking hash-set.
	 * 
	 * 
	 * @param nums
	 */
	public static List<List<Integer>> find_3Sum(int[] nums) {
		Arrays.sort(nums);
		Set<List<Integer>> set = new HashSet<List<Integer>>();
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		for (int i = 0; i < nums.length; i++) {
			int left = i + 1;
			int right = nums.length - 1;
			while (left < right) {
				int sum = nums[i] + nums[left] + nums[right];
				if (sum == 0) {
					set.add(Arrays.asList(new Integer[] { nums[i], nums[left], nums[right] }));
					left = left + 1;
					right = right - 1;
				} else if (sum < 0) {
					left = left + 1;
				} else {
					right = right - 1;
				}
			}
		}
		System.out.println(set);
		result.addAll(set);
		return result;
	}

	public static void main(String[] args) {
		find_3Sum(new int[] { -1, 0, 1, 2, -1, -4 });
	}

}

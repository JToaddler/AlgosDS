package com.leetcode.scratchpad;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		Set<List<Integer>> resultSet = new HashSet<List<Integer>>();
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		for (int i = 0; i < nums.length; i++) {
			int j = i + 1;
			int k = nums.length - 1;
			while (j < k) {
				int sum = nums[i] + nums[j] + nums[k];
				if (sum == 0) {
					resultSet.add(Arrays.asList(new Integer[] { nums[i], nums[j], nums[k] }));
					j = j + 1;
					k = k - 1;
				} else if (sum < 0) {
					j = j + 1;
				} else {
					k = k - 1;
				}
			}
		}
		result.addAll(resultSet);
		return result;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.threeSum(new int[] { -1, 0, 1, 2, -1, -4 }));
	}

}

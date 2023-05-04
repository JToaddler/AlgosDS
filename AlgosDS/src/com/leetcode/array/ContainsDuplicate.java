package com.leetcode.array;

import java.util.HashSet;

public class ContainsDuplicate {
	/**
	 * 
	 * Time Complexity = BigO(N) where N is no of integers to traverse
	 * 
	 * 
	 * Space Complexity = BigO(N) as for worse case it can add N no of nodes
	 * 
	 * 
	 * @param nums
	 * @return
	 */
	public static boolean containsDuplicate(int[] nums) {

		HashSet<Integer> set = new HashSet<Integer>();
		for (int i : nums) {
			if (!set.add(i)) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(containsDuplicate(new int[] { 1, 2, 3 }));
	}
}
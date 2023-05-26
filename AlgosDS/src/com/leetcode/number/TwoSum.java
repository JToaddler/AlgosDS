package com.leetcode.number;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * https://leetcode.com/problems/two-sum/
 * 
 * 
 * 
 * 
 * @author Anto
 *
 */
public class TwoSum {

	/**
	 * 
	 * Complexity Analysis
	 * 
	 * Time complexity: O(n^2). For each element, we try to find its complement by
	 * looping through the rest of the array which takes O(n^2) time. Therefore, the
	 * time complexity is O(n^2).
	 * 
	 * Space complexity: O(1). The space required does not depend on the size of the
	 * input array, so only constant space is used.
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int[] twoSum_BruteForce(int[] nums, int target) {
		int[] result = new int[2];
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums.length; j++) {
				if (i != j && nums[j] == target - nums[i]) {
					result = new int[] { i, j };
				}
			}
		}
		return result;
	}

	/**
	 * Optimized : 1 pass array & map
	 * 
	 * 
	 * Time complexity: O(n). We traverse the list containing nnn elements only
	 * once. Each lookup in the table costs only O(1) time.
	 * 
	 * Space complexity: O(n). The extra space required depends on the number of
	 * items stored in the hash table, which stores at most nnn elements.
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int[] twoSum_Optimized(int[] nums, int target) {

		Map<Integer, Integer> result = new HashMap<Integer, Integer>();

		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];
			if (result.containsKey(complement)) {
				return new int[] { i, result.get(complement) };
			}
			result.put(nums[i], i);
		}
		return null;
	}

	public static void main(String[] args) {
		int[] test1Array = new int[] { 3, 8, 2, 9, 1, 5, 4, 51, 78, 89, 234, 56, 78, 67, 89, 90, 256, 831, 679, 8989,
				435, 34, 23, 67, 89 };
		int test1Target = 55;
		System.out.println(Arrays.toString(twoSum_BruteForce(test1Array, test1Target)));
		System.out.println(Arrays.toString(twoSum_Optimized(test1Array, test1Target)));
	}

}

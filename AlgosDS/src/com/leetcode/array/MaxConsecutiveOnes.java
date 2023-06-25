package com.leetcode.array;

/**
 * 
 * https://leetcode.com/problems/max-consecutive-ones/
 * 
 * @author Anto
 *
 */
public class MaxConsecutiveOnes {
	public static void main(String[] args) {
		findMaxConsecutiveOnes(new int[] { 1, 1 });
	}

	public static int findMaxConsecutiveOnes(int[] nums) {
		if (nums.length == 1)
			return 1;
		int consecutiveCount = 0;
		int maxCount = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 1)
				consecutiveCount++;
			else
				consecutiveCount = 0;
			maxCount = Math.max(maxCount, consecutiveCount);
		}
		return maxCount;
	}
}

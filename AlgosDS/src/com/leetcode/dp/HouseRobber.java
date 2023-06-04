package com.leetcode.dp;

/**
 * https://leetcode.com/problems/house-robber/solutions/1605334/java-dp-with-and-without-space-explained/
 * 
 * @author Anto
 *
 */
public class HouseRobber {

	/**
	 * 
	 * TC (N) SP (N)
	 * 
	 * 
	 * @param nums
	 * @return
	 */
	public static int rob(int[] nums) {

		int n = nums.length;
		int[] dp = new int[n];

		dp[0] = nums[0];
		if (n == 1) {
			return nums[0];
		}
		dp[1] = Math.max(nums[0], nums[1]);

		for (int i = 2; i < n; i++) {
			dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
		}
		return dp[n - 1]; // return the last index in the dp array
	}

	/**
	 * 
	 * TC (N) SP (1)
	 * 
	 * 
	 * @param nums
	 * @return
	 */
	public static int rob2(int[] nums) {

		int curMax = 0;
		int preMax = 0;

		for (int num : nums) {
			int temp = curMax;
			curMax = Math.max(preMax + num, curMax);
			preMax = temp;
		}

		return curMax;
	}

	public static void main(String[] args) {
		System.out.println(rob(new int[] { 1, 2, 3, 1 }));
		System.out.println(rob2(new int[] { 1, 2, 3, 1 }));
	}
}

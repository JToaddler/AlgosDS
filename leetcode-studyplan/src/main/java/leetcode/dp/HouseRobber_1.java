package leetcode.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/house-robber/
 * 
 */
public class HouseRobber_1 {

	/**
	 * Bottom up tabulation
	 * 
	 * Time Complexity: O(N)
	 * 
	 * Space Complexity: O(N)
	 * 
	 */
	public int rob_bottom_Up(int[] nums) {
		if (nums.length == 1)
			return nums[0];
		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		dp[1] = Math.max(nums[0], nums[1]);
		for (int i = 2; i < nums.length; i++) {
			dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
		}
		return dp[nums.length - 1];
	}

	int[] nums;
	Map<Integer, Integer> map = new HashMap<>();

	/**
	 * Bottom up tabulation
	 * 
	 * Time Complexity: O(N)
	 * 
	 * Space Complexity: O(N)
	 * 
	 */
	public int rob_topDown(int[] nums) {
		if (nums.length == 1)
			return nums[0];
		this.nums = nums;
		return dp(nums.length - 1);
	}

	public int dp(int i) {
		if (i == 0)
			return nums[0];
		else if (i == 1)
			return Math.max(nums[0], nums[1]);
		if (!map.containsKey(i)) {
			int max = Math.max(dp(i - 1), dp(i - 2) + nums[i]);
			map.put(i, max);
		}
		return map.get(i);
	}

}

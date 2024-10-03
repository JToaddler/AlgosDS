package leetcode.slidingwindow;

/**
 * 209
 * 
 * https://leetcode.com/problems/minimum-size-subarray-sum/description/
 * 
 */
public class MinSizeSubArray {

	public static void main(String[] args) {
		int[] nums = new int[] { 6, 3, 5, 2 };
		System.out.println(minSubArrayLen(9, nums));
	}

	public static int minSubArrayLen(int target, int[] nums) {
		int left = 0, right = 0, currentSum = 0;
		int res = Integer.MAX_VALUE;
		for (right = 0; right < nums.length; right++) {
			currentSum += nums[right];
			while (currentSum >= target) {
				res = Math.min(res, right - left + 1);
				currentSum -= nums[left];
				left++;
			}
		}
		return res == Integer.MAX_VALUE ? 0 : res;
	}

}

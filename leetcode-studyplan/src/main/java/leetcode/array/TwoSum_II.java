package leetcode.array;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
 * 
 * 
 */
public class TwoSum_II {
	public static void main(String[] args) {
		int[] nums = { 0, 0, 3, 4 };
		System.out.println(Arrays.toString(twoSum(nums, 0)));
	}

	public static int[] twoSum(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		while (left < right) {
			int sum = nums[left] + nums[right];
			if (sum == target) {
				return new int[] { left + 1, right + 1 };
			} else if (sum < target) {
				left += 1;
			} else
				right -= 1;
		}
		return new int[] { -1, -1 };
	}

}
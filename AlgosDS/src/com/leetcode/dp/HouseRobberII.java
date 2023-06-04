package com.leetcode.dp;

import java.util.Arrays;

public class HouseRobberII {

	public static void main(String[] args) {

		int[] houses = new int[] { 2, 3, 2 };
		System.out.println(findMax(houses));
	}

	public static int findMax(int[] houses) {
		return Math.max(rob(Arrays.copyOfRange(houses, 0, houses.length - 1)),
				rob(Arrays.copyOfRange(houses, 1, houses.length)));
	}

	private static int rob(int[] nums) {
		System.out.println(" " + Arrays.toString(nums));
		int curMax = 0, preMax = 0;

		for (int num : nums) {
			int temp = curMax;
			curMax = Math.max(preMax + num, curMax);
			preMax = temp;
		}
		return curMax;
	}

}

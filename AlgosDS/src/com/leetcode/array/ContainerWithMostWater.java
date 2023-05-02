package com.leetcode.array;

public class ContainerWithMostWater {

	/**
	 * 
	 * https://leetcode.com/problems/container-with-most-water/
	 * 
	 * Complexity Analysis
	 * 
	 * Time complexity: O(n^2). Calculating area for all n(n−1)/2 height pairs.
	 * 
	 * 
	 * Space complexity: O(1) Constant extra space is used.
	 * 
	 * 
	 * @param range
	 * @return
	 */
	public static int calculateMaxArea_BruteForce(int[] range) {
		int max_area = 0;

		if (range == null || range.length == 0) {
			return max_area;
		}

		for (int i = 0; i < range.length; i++) {
			for (int j = i + 1; j < range.length; j++) {
				int height = Math.min(range[i], range[j]);
				int width = j - i;
				int area = Math.abs(height * width);
				max_area = Math.max(max_area, area);
//				System.out.println(max_area);
			}
		}
		System.out.println(max_area);
		return max_area;
	}

	/**
	 * 
	 * 
	 * 
	 * Complexity Analysis
	 * 
	 * Time complexity: O(n). Single pass.
	 * 
	 * Space complexity: O(1). Constant space is used.
	 * 
	 * @param range
	 * @return
	 */
	public static int calculateMaxArea_Optimized(int[] range) {

		int max_area = 0;
		if (range == null || range.length == 0) {
			return max_area;
		}
		int left = 0;
		int right = range.length - 1;
		while (left < right) {
			int width = right - left;
			int height = Math.min(range[right], range[left]);
			max_area = Math.max(max_area, Math.abs(width * height));
			if (range[left] <= range[right]) {
				left = left + 1;
			} else {
				right = right - 1;
			}
		}
		System.out.println(max_area);
		return max_area;
	}

	public static void main(String[] args) {

		calculateMaxArea_BruteForce(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 });
		calculateMaxArea_Optimized(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 });

	}

}

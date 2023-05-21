package com.leetcode.array;

import java.util.Stack;

/**
 * 
 * https://leetcode.com/problems/largest-rectangle-in-histogram/
 * 
 * 
 * https://www.youtube.com/watch?v=zx5Sw9130L0
 * 
 * 
 * 
 * @author Anto
 *
 */
public class LargestRectangleInHistogram {

	public static void main(String[] args) {
		int[] heights = { 2, 1, 6, 6, 8, 10 };
		findMaxRectangle(heights);
	}

	public static int findMaxRectangle(int[] heights) {

		int maxArea = 0;
		Stack<int[]> stack = new Stack<int[]>();

		if (heights.length == 1) {
			return heights[0];
		}

		for (int i = 0; i < heights.length; i++) {
			int[] curr = { i, heights[i] };
			while (!stack.isEmpty() && stack.peek()[1] > curr[1]) {
				int[] popped = stack.pop();
				int width = i - popped[0];
				int height = popped[1];
				maxArea = Math.max(maxArea, width * height);
				curr[0] = popped[0];
			}
			stack.push(curr);
		}
		int len = heights.length;

		while (!stack.isEmpty()) {
			int[] curr = stack.pop();
			maxArea = Math.max(maxArea, (len - curr[0]) * curr[1]);
		}
		System.out.println("Max area " + maxArea);
		return maxArea;
	}

}

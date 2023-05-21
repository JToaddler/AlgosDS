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
		int[] heights = { 2, 1, 5, 6, 2, 3 };
		findMaxRectangle(heights);
	}

	public static int findMaxRectangle(int[] heights) {

		int maxArea = 0;
		if (heights.length == 1) {
			return heights[0];
		}
		Stack<int[]> stack = new Stack<int[]>();
		for (int i = 0; i < heights.length; i++) {
			int[] curr = { i, heights[i] };
			while (!stack.isEmpty() && stack.peek()[1] > curr[1]) {
				int[] popped = stack.pop();
				int height = popped[1];
				int width = i - popped[0];
				maxArea = Math.max(maxArea, height * width);
				curr[0] = popped[0];
			}
			stack.push(curr);
		}
		int len = heights.length;
		while (!stack.isEmpty()) {
			int[] curr = stack.pop();
			maxArea = Math.max(maxArea, ((len - curr[0]) * curr[1]));
		}
		System.out.println(maxArea);
		return maxArea; // TODO
	}

}

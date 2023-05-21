package com.leetcode.matrix;

import java.util.Arrays;
import java.util.Random;
import java.util.Stack;

/**
 * 
 * first refer LargestRectangleInHistogram.java
 * 
 * https://leetcode.com/problems/maximal-rectangle/
 * 
 * https://leetcode.com/problems/maximal-rectangle/solutions/29055/my-java-solution-based-on-maximum-rectangle-in-histogram-with-explanation/
 * 
 * @author Anto
 *
 */
public class LargestRectangle {

	public static void main(String[] args) {

		int[][] matrix = generateGrid(6, 6);
		System.out.println("Largest Rectangle Area :" + findLargestRectangle(matrix));
	}

	public static int findLargestRectangle(int[][] matrix) {

		int maxArea = 0;
		if (matrix == null || matrix.length == 0) {
			return maxArea;
		}

		int[] heights = new int[matrix[0].length];

		for (int i = 0; i < matrix[0].length; i++) {
			heights[i] = matrix[0][i];
		}
		maxArea = maxRectangleArea(heights);

		for (int i = 1; i < matrix.length; i++) {
			adjustHeight(matrix, heights, i);
			int newArea = maxRectangleArea(heights);
			maxArea = Math.max(maxArea, newArea);
		}
		return maxArea;
	}

	public static void adjustHeight(int[][] matrix, int[] heights, int row) {
		for (int i = 0; i < matrix[row].length; i++) {
			if (matrix[row][i] == 1) {
				heights[i] = heights[i] + 1;
			}else {
				heights[i] = 0;
			}
		}
	}

	public static int maxRectangleArea(int[] heights) {
		int maxArea = 0;
		if (heights == null || heights.length == 0)
			return maxArea;
		if (heights.length == 1)
			return heights[0];
		Stack<int[]> stack = new Stack<int[]>();
		for (int i = 0; i < heights.length; i++) {
			int[] curr = { i, heights[i] };
			while (!stack.isEmpty() && stack.peek()[1] > heights[i]) {
				int[] popped = stack.pop();
				int area = (i - popped[0]) * popped[1]; // width * height
				maxArea = Math.max(maxArea, area);
				curr[0] = popped[0];
			}
			stack.push(curr);
		}
		int len = heights.length;
		while (!stack.isEmpty()) {
			int[] curr = stack.pop();
			int area = (len - curr[0]) * curr[1];
			maxArea = Math.max(maxArea, area);
		}
		return maxArea;
	}

	public static int[][] generateGrid(int rowCount, int colCount) {
		Random rand = new Random();
		int[][] array = new int[rowCount][colCount];
		for (int i = 0; i < rowCount; i++) {
			for (int j = 0; j < colCount; j++) {
				array[i][j] = rand.nextInt(2);
			}
		}
		printArray(array);
		return array;
	}

	public static void printArray(int[][] array) {
		for (int[] row : array)
			System.out.println(Arrays.toString(row));
		System.out.println("------------------");
	}

}
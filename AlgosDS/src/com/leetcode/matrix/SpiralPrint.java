package com.leetcode.matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * https://leetcode.com/problems/spiral-matrix/
 * 
 * https://leetcode.com/problems/spiral-matrix/solutions/20570/clean-java-readable-human-friendly-code/
 * 
 * @author Anto
 *
 */
public class SpiralPrint {

	public static void main(String[] args) {
		int[][] nums = generateGrid(5, 5);
		traverseSpiral(nums);
	}

	public static List<Integer> traverseSpiral(int[][] matrix) {
		List<Integer> result = new ArrayList<Integer>();
		if (matrix.length == 0 || matrix[0].length == 0)
			return result;

		int top = 0, bottom = matrix.length - 1;
		int left = 0, right = matrix[0].length - 1;

		while (true) {

			// left to right
			for (int i = left; i <= right; i++)
				result.add(matrix[top][i]);
			top++;
			if (left > right)
				break;

			// top to bottom
			for (int i = top; i <= bottom; i++)
				result.add(matrix[i][right]);
			--right;
			if (top > bottom)
				break;

			// right to left
			for (int i = right; i >= left; i--)
				result.add(matrix[bottom][i]);
			--bottom;
			if (left > right)
				break;

			// bottom to top
			for (int i = bottom; i >= top; i--)
				result.add(matrix[i][left]);
			++left;

			if (top > bottom)
				break;
		}
		System.out.println(result);
		return result;
	}

	public static int[][] generateGrid(int rCount, int cCount) {
		int num = 10;
		int[][] randomGrid = new int[rCount][cCount];
		for (int i = 0; i < rCount; i++) {
			for (int j = 0; j < cCount; j++) {
				randomGrid[i][j] = ++num;
			}
		}
		for (int[] num1 : randomGrid)
			System.out.println(Arrays.toString(num1));
		return randomGrid;
	}

}

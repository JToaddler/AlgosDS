package com.leetcode.dp;

import java.util.Arrays;
import java.util.Random;

/**
 * https://leetcode.com/problems/maximal-square/editorial/
 * 
 * Approach #2
 * 
 * 
 * @author Anto
 *
 */
public class LargestSquare {

	public static void main(String[] args) {
		int[][] matrix = generateGrid(5, 5);
		int maxSqr = findLargestMatrixDP(matrix);
		System.out.println("Max Square : " + maxSqr);
	}

	public static int findLargestMatrixDP(int[][] matrix) {
		int row = matrix.length;
		int col = row > 0 ? matrix[0].length : 0;
		int[][] dp = new int[row + 1][col + 1];
		int maxSqr = 0;

		for (int i = 1; i < row; i++) {
			for (int j = 1; j < col; j++) {
				if (matrix[i - 1][j - 1] == 1) {
					dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j - 1]), dp[i - 1][j]) + 1;
					maxSqr = Math.max(maxSqr, dp[i][j]);
				}
			}
		}
		return maxSqr * maxSqr;
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

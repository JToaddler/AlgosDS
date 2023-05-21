package com.leetcode.matrix;

import java.util.Arrays;

/**
 * 
 * https://www.youtube.com/watch?v=fMSJSS7eO1w
 * 
 * Works only for N x N 2D array
 * 
 * @author Anto
 */
public class InPlaceRotation2DArray {

	public static void main(String[] args) {

		int[][] matrix = generateGrid(5, 5);
		rotateArray(matrix);
	}

	public static void rotateArray(int[][] matrix) {

		int l = 0;
		int r = matrix.length - 1;

		while (l < r) {
			for (int i = 0; i < r - l; i++) {

				int top = l;
				int bottom = r;

				int topLeft = matrix[top][l + i];

				matrix[top][l + i] = matrix[bottom - i][l];

				matrix[bottom - i][l] = matrix[bottom][r - i];

				matrix[bottom][r - i] = matrix[top + i][r];

				matrix[top + i][r] = topLeft;
			}
			l++;
			r--;
		}
		printArray(matrix);
	}

	public static int[][] generateGrid(int rowCount, int colCount) {
		int[][] array = new int[rowCount][colCount];
		for (int i = 0; i < rowCount; i++) {
			for (int j = 0; j < colCount; j++) {
				array[i][j] = (int) ((Math.random() * Math.random() * 10));
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

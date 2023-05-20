package com.leetcode.matrix;

import java.util.Arrays;

/**
 * @author Anto
 */
public class InPlaceRotation2DArray {

	public static void main(String[] args) {
		
	}

	public static int[][] generateGrid(int rowCount, int colCount) {
		int[][] array = new int[rowCount][colCount];
		for (int i = 0; i < rowCount; i++) {
			for (int j = 0; j < colCount; j++) {
				array[i][j] = (int) ((Math.random() * Math.random() * 10));
			}
		}
		for (int[] row : array)
			System.out.println(Arrays.toString(row));
		System.out.println("------------------");
		return array;//
	}
}

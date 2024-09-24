package com.leetcode.matrix;

import java.util.Arrays;

public class PrintDiagnol2DArray {

	public static void main(String[] args) {

		int[][] grid = generateGrid(4, 4);
		for (int i = 0; i < grid.length; i++)
			System.out.println(Arrays.toString(grid[i]));
		System.out.println("----------------------------");

		for (int i = 0; i < grid.length; i++) {
			int j = i;
			System.out.println(grid[i][j]);
		}
	}

	public static int[][] generateGrid(int rCount, int cCount) {
		int[][] randomGrid = new int[rCount][cCount];
		for (int i = 0; i < rCount; i++) {
			for (int j = 0; j < cCount; j++) {
				randomGrid[i][j] = (int) ((Math.random() * 10) % 2);
			}
		}
		return randomGrid;
	}

}

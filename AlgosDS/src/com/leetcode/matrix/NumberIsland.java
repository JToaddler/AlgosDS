package com.leetcode.matrix;

import java.util.Arrays;

public class NumberIsland {

	public static void main(String[] args) {

		int[][] grid = generateGrid(4, 4);
		findIsland(grid);
	}

	public static void findIsland(int[][] grid) {
		int count = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 1) {
					count++;
					markVisited(grid, i, j);
				}
			}
		}
		System.out.println("Total Island:" + count);
	}

	public static void markVisited(int[][] grid, int i, int j) {
		if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == 0) {
			return;
		}
		grid[i][j] = 0;
		markVisited(grid, i, j + 1);
		markVisited(grid, i, j - 1);
		markVisited(grid, i - 1, j);
		markVisited(grid, i + 1, j);
	}

	public static int[][] generateGrid(int rCount, int cCount) {
		int[][] randomGrid = new int[rCount][cCount];
		for (int i = 0; i < rCount; i++) {
			for (int j = 0; j < cCount; j++) {
				randomGrid[i][j] = (int) ((Math.random() * 10) % 2);
			}
		}
		for (int[] rows : randomGrid)
			System.out.println(Arrays.toString(rows));
		return randomGrid;
	}
}

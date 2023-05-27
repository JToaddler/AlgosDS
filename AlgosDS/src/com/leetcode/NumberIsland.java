package com.leetcode;

import java.util.Arrays;

public class NumberIsland {

	public static void main(String[] args) {

		int rCount = 4;
		int cCount = 4;

		Integer[][] grid = NumberIsland.generateGrid(rCount, cCount);

		for (int i = 0; i < grid.length; i++) {
			System.out.println(Arrays.asList(grid[i]));
		}
		System.out.println("--------------");

		System.out.println("No of island : " + NumberIsland.findIslandCount(grid));

	}

	public static Integer[][] generateGrid(int rCount, int cCount) {
		Integer[][] randomGrid = new Integer[rCount][cCount];
		for (int i = 0; i < rCount; i++) {
			for (int j = 0; j < cCount; j++) {
				randomGrid[i][j] = (int) ((Math.random() * 10) % 2);
			}
		}
		return randomGrid;
	}

	public static int findIslandCount(Integer[][] grid) {
		int islandCount = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 1) {
					islandCount++;
					markVisitedPath(grid, i, j);
				}
			}
		}
		return islandCount;
	}

	public static void markVisitedPath(Integer[][] grid, int i, int j) {

		if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == 0) {
			return;
		}
		grid[i][j] = 0;
		markVisitedPath(grid, i + 1, j);
		markVisitedPath(grid, i - 1, j);
		markVisitedPath(grid, i, j + 1);
		markVisitedPath(grid, i, j - 1);
	}

}

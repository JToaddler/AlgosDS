package com.leetcode.matrix;

/**
 * https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/
 * 
 */
public class CountNegatives {

	public int countNegatives(int[][] grid) {

		int rows = grid.length;
		int cols = grid[0].length;

		if (grid[0][0] < 0)
			return rows * cols;
		else if (grid[rows - 1][cols - 1] > 0)
			return 0;
		else {
			int totCount = 0;
			int lastNeg = cols - 1;
			for (int i = 0; i < rows; i++) {
				if (grid[i][0] < 0)
					totCount = totCount + cols;
				else if (grid[i][cols - 1] > 0)
					continue;
				else {
					int l = 0, r = lastNeg;
					while (l <= r) {
						int mid = l + (r - l) / 2;
						if (grid[i][mid] < 0)
							r = mid - 1;
						else
							l = mid + 1;
					}
					totCount = totCount + (cols - l);
					lastNeg = l;
				}
			}
			return totCount;
		}
	}
}
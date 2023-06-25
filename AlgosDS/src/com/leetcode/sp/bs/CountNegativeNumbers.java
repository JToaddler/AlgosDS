package com.leetcode.sp.bs;

/**
 * https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix
 * 
 * @author Anto
 *
 */
public class CountNegativeNumbers {

	public static void main(String[] args) {
		
	}

	public int countNegatives(int[][] grid) {
		int rows = grid.length;
		int cols = grid[0].length;
		if (grid[0][0] < 0)
			return rows * cols;
		if (grid[rows - 1][cols - 1] >= 0)
			return 0;
		else {
			int lastNeg = cols - 1;
			int totalCount = 0;
			for (int i = 0; i < rows; i++) {
				if (grid[i][0] < 0)
					totalCount += cols;
				else if (grid[i][cols - 1] > 0)
					continue;
				else {
					int left = 0, right = lastNeg;
					while (left <= right) {
						int mid = left + (right - left) / 2;
						if (grid[i][mid] < 0)
							right = mid - 1;
						else
							left = mid + 1;
					}
					lastNeg = left;
					totalCount = totalCount + cols - left;
				}
			}
			return totalCount;
		}
	}

}

package leetcode.matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import leetcode.input.ArrayBuilder;

/**
 * 
 * https://leetcode.com/problems/diagonal-traverse/description/
 * 
 * 
 */
public class DiagonalTraverse_498 {

	public static void main(String[] args) {

		// int[][] grid = ArrayBuilder.build2dArray(3, 3);
		int[][] grid = ArrayBuilder.build2dArray(6, 2);
		findDiagonalOrder(grid);
	}

	public static int[] findDiagonalOrder(int[][] grid) {
		int[] row = grid[0];
		int n = grid.length;
		int m = grid[0].length;
		int[] nums = new int[n * m];
		int k = 0;
		if (row.length == 1) {
			for (int[] arr : grid) {
				nums[k++] = arr[0];
			}
			return nums;
		}
		List<Integer> list = new ArrayList<>();
		boolean flip = true;
		for (int index = 0; index < m; index++) {
			int i = 0;
			for (int j = index; j >= 0 && i < n; j--, i++) {
				list.add(grid[i][j]);
			}
			if (flip) {
				for (int a = list.size() - 1; a >= 0; a--) {
					nums[k++] = list.get(a);
				}
			} else {
				for (Integer a : list)
					nums[k++] = a;
			}
			flip = flip ? false : true;
			list.clear();
		}
		for (int index = 1; index < n; index++) {
			int i = index;
			for (int j = m - 1; j >= 0 && i < n; j--, i++) {
				list.add(grid[i][j]);
			}
			if (flip) {
				for (int a = list.size() - 1; a >= 0; a--) {
					nums[k++] = list.get(a);
				}
			} else {
				for (Integer a : list)
					nums[k++] = a;
			}
			flip = flip ? false : true;
			list.clear();
		}
		return nums;
	}
}

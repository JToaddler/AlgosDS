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

		int[][] grid = ArrayBuilder.build2dArray(6, 2);

		findDiagonalOrder(grid);
	}

	public static int[] findDiagonalOrder(int[][] grid) {
		int[] row = grid[0];
		List<Integer> list = new ArrayList<>();
		int[] nums = new int[grid.length * grid[0].length];
		int k = 0;
		if (row.length == 1) {
			for (int[] arr : grid) {
				nums[k++] = arr[0];
			}
			return nums;
		}
		boolean flip = true;
		for (int index = 0; index < row.length; index++) {
			int i = 0;
			for (int j = index; j >= 0 && i < grid.length; j--, i++) {
				list.add(grid[i][j]);
			}
			if (flip) {
				for (int x = list.size() - 1; x >= 0; x--) {
					nums[k++] = list.get(x);
				}
			} else {
				for (int a : list) {
					nums[k++] = a;
				}
			}
			list.clear();
			flip = flip ? false : true;
		}
		System.out.println(Arrays.toString(nums));
		for (int index = 1; index < grid.length; index++) {
			int i = index;
			for (int j = row.length - 1; j >= 0 && i < grid.length; j--, i++) {
				list.add(grid[i][j]);
			}
			if (flip) {
				for (int x = list.size() - 1; x >= 0; x--) {
					nums[k++] = list.get(x);
				}
			} else {
				for (int a : list) {
					nums[k++] = a;
				}
			}
			list.clear();
			flip = flip ? false : true;
		}
		System.out.println(Arrays.toString(nums));
		return nums;
	}
}

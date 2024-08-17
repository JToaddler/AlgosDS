package leetcode.input;

import java.util.Arrays;

public class ArrayBuilder {

	public static int[][] build2dArray(int rows, int col) {

		int[][] array = new int[rows][col];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < col; j++) {
				array[i][j] = Double.valueOf(Math.random() * 10).intValue();
			}
		}
		for (int[] row : array) {
			System.out.println(Arrays.toString(row));
		}
		return array;
	}

	public static int[] buildArray(int count) {
		int[] nums = new int[count];
		for (int i = 0; i < count; i++) {
			nums[i] = Double.valueOf(Math.random() * 100).intValue();
		}
		System.out.println(Arrays.toString(nums));
		return nums;
	}

}

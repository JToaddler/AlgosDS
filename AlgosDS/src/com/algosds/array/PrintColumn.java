package com.algosds.array;

import java.util.Arrays;

public class PrintColumn {

	public static void main(String[] args) {

		Integer[][] nums = generateGrid(4, 4);
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < nums[0].length; i++) {
			for (int j = 0; j < nums.length; j++) {
				sb.append(nums[j][i] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	public static Integer[][] generateGrid(int rCount, int cCount) {
		int num = 0;
		Integer[][] randomGrid = new Integer[rCount][cCount];
		for (int i = 0; i < rCount; i++) {
			for (int j = 0; j < cCount; j++) {
				randomGrid[i][j] = ++num;
			}
		}
		for (Integer[] nums : randomGrid)
			System.out.println(Arrays.toString(nums));
		return randomGrid;
	}

}

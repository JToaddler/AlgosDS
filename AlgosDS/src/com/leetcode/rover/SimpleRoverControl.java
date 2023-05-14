package com.leetcode.rover;

import java.util.Arrays;

public class SimpleRoverControl {

	public static void main(String[] args) {

		int count = 5;
		String[] commands = { "RIGHT", "DOWN", "LEFT", "LEFT", "DOWN" };
		int[][] array = generateArray(count);
		moveRover(commands, array, count);
		
	}

	private static int moveRover(String[] commands, int[][] array, int count) {

		int row = 0;
		int col = 0;

		for (String command : commands) {

			switch (command) {
			case "RIGHT":
				if (col < count - 1) {
					col++;
				}
				break;
			case "DOWN":
				if (row < count - 1) {
					row++;
				}
				break;
			case "UP":
				if (row > 0) {
					row--;
				}
				break;
			case "LEFT":
				if (col > 0) {
					col--;
				}
				break;
			}
		}

		System.out.println(array[row][col]);
		return array[row][col];
	}

	public static int[][] generateArray(int count) {

		int[][] array = new int[count][count];
		int index = 0;
		for (int i = 0; i < count; i++) {
			for (int j = 0; j < count; j++) {
				array[i][j] = index++;
			}
			System.out.print(Arrays.toString(array[i]));
			System.out.println();
		}
		System.out.println();
		return array;

	}
}

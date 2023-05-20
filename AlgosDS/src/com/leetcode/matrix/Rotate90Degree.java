package com.leetcode.matrix;

import java.util.Arrays;

/**
 * 
 * for n X n array (not for m X n array)
 * 
 * Rotate Left:
 * 
 * reverse transpose
 * 
 * Rotate right:
 * 
 * transpose reverse
 * 
 * 
 * Time Complexity: O(N2) + O(N2) where N is the size of the array. Auxiliary
 * Space: O(1). As a constant space is needed
 * 
 * @author Anto
 *
 */
public class Rotate90Degree {

	public static void main(String[] args) {
		rotateLeft();
		rotateRight();
	}

	public static void rotateRight() {
		int[][] array = generateGrid(4, 2);
		array = transPoseMXM(array);
		array = reverse(array);
		System.out.println("After rotate right--------");
		for (int[] rows : array)
			System.out.println(Arrays.toString(rows));

	}

	public static void rotateLeft() {
		int[][] array = generateGrid(4, 2);
		array = reverse(array);
		array= transPoseMXM(array);
		System.out.println("After rotate left---------");
		for (int[] rows : array)
			System.out.println(Arrays.toString(rows));

	}

	public static int[][] generateGrid(int rowCount, int colCount) {
		int[][] array = new int[rowCount][colCount];
		for (int i = 0; i < rowCount; i++) {
			for (int j = 0; j < colCount; j++) {
				array[i][j] = (int) ((Math.random() * Math.random() * 10));
			}
		}
		System.out.println("------------------");
		for (int[] row : array)
			System.out.println(Arrays.toString(row));
		System.out.println("------------------");
		return array;//
	}

	public static int[][] transPoseNXN(int[][] array) {
		int row = array.length;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < i; j++) {
				int temp = array[i][j];
				array[i][j] = array[j][i];
				array[j][i] = temp;
			}
		}
		return array;
	}

	public static int[][] transPoseMXM(int[][] array) {

		int row = array.length;
		int col = array[0].length;
		int[][] result = new int[col][row];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				result[j][i] = array[i][j];
			}
		}
		return result;
	}

	public static int[][] reverse(int[][] array) {

		for (int[] row : array) {
			int n = row.length;
			for (int i = 0; i < row.length / 2; i++) {
				int temp = row[i];
				row[i] = row[n - 1];
				row[n - 1] = temp;
				n--;
			}
		}
		return array;
	}

}
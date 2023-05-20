package com.leetcode.matrix;

/**
 * 
 * transpose a[i][j] => b[j][i]
 * 
 * 
 * @author Anto
 *
 */
public class TransposeArray {

	public static void main(String[] arsg) {

		Integer[][] array = generateGrid(4, 2);
		for (int i = 0; i < array.length; i++) {
			print(array[i]);
		}
		Integer[][] result = transpose(array);
		System.out.println("-------------------------");
		for (int i = 0; i < result.length; i++) {
			print(result[i]);
		}

	}

	public static Integer[][] transpose(Integer[][] array) {

		int rowCount = array.length;
		int colCount = array[0].length;
		Integer[][] result = new Integer[colCount][rowCount];
		for (int i = 0; i < rowCount; i++) {
			for (int j = 0; j < colCount; j++) {
				result[j][i] = array[i][j];
			}
		}
		return result;
	}

	public static Integer[][] generateGrid(int rCount, int cCount) {
		Integer[][] randomGrid = new Integer[rCount][cCount];
		for (int i = 0; i < rCount; i++) {
			for (int j = 0; j < cCount; j++) {
				randomGrid[i][j] = (int) ((Math.random() * 10));
			}
		}
		return randomGrid;
	}

	public static void print(Integer[] letters) {
		StringBuilder sb = new StringBuilder("[");
		for (int i = 0; i < letters.length; i++) {
			sb.append(letters[i] + ", ");
		}
		System.out.println(sb.append("]").toString());
	}

};
package leetcode.matrix;

import java.util.ArrayList;
import java.util.List;

import leetcode.input.ArrayBuilder;

/**
 * https://leetcode.com/problems/spiral-matrix/description/
 */
public class SpiralMatrix_54 {

	public static void main(String[] args) {

		int[][] matrix = ArrayBuilder.build2dArray(3, 4);
		spiralOrder(matrix);
	}

	public static List<Integer> spiralOrder(int[][] matrix) {
		int rowCount = matrix.length;
		int colCount = matrix[0].length;
		int count = rowCount * colCount;
		int up = 0;
		int left = 0;
		int right = colCount - 1;
		int down = rowCount - 1;
		List<Integer> list = new ArrayList<>(count);

		while (list.size() < count) {
			// left to right
			for (int col = left; col <= right; col++) {
				list.add(matrix[up][col]);
			}
			// up to down
			for (int row = up + 1; row <= down; row++) {
				list.add(matrix[row][right]);
			}

			if (up != down) {
				// right to left
				for (int col = right - 1; col >= left; col--) {
					list.add(matrix[down][col]);
				}
			}
			if (left != right) {
				// down to up
				for (int row = down - 1; row >= up + 1; row--) {
					list.add(matrix[row][left]);
				}
			}
			up++;
			right--;
			down--;
			left++;
		}
		System.out.println(list);
		return list;
	}

}

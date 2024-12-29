package leetcode.matrix;

import java.util.HashSet;

/**
 * https://leetcode.com/problems/valid-sudoku/
 * 
 */
public class ValidSudoKu {

	/**
	 * Time complexity: O(N 2 ) because we need to traverse every position in the
	 * board, and each of the four check steps is an O(1) operation.
	 * 
	 * 
	 * Space complexity: O(3N) because we need to create 3N arrays each with size N
	 * to store all previously seen numbers for all rows, columns, and boxes.
	 * 
	 * 
	 * 
	 */
	public boolean isValidSudoku(char[][] board) {

		int n = 9;
		HashSet<Character>[] rows = new HashSet[n];
		HashSet<Character>[] cols = new HashSet[n];
		HashSet<Character>[] box = new HashSet[n];

		for (int i = 0; i < n; i++) {
			rows[i] = new HashSet<Character>();
			cols[i] = new HashSet<Character>();
			box[i] = new HashSet<Character>();
		}

		for (int row = 0; row < n; row++) {
			for (int col = 0; col < n; col++) {

				char val = board[row][col];
				if (val == '.')
					continue;

				if (rows[row].contains(val))
					return false;
				rows[row].add(val);

				if (cols[col].contains(val))
					return false;
				cols[col].add(val);

				int boxId = (row / 3 * 3) + (col / 3); //
				if (box[boxId].contains(val))
					return false;
				box[boxId].add(val);

				/**
				 * <code>
				 * String boxId = "" +(row/3 ) + (col/3);
				 * Set<Character> boxSet = map.getOrDefault(boxId, new HashSet<Character>());
				 * if(boxSet.contains(val)) 
				 * 		return false;
				 * boxSet.add(val); 
				 * map.putIfAbsent(boxId, boxSet);
				 * </code>
				 */

			}
		}
		return true;
	}
}

package leetcode.backtracking;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/n-queens-ii/description/
 * 
 * Time complexity: O(N!), where N is the number of queens (which is the same as
 * the width and height of the board).
 * 
 * Unlike the brute force approach, we place a queen only on squares that aren't
 * attacked. For the first queen, we have N options. For the next queen, we
 * won't attempt to place it in the same column as the first queen, and there
 * must be at least one square attacked diagonally by the first queen as well.
 * Thus, the maximum number of squares we can consider for the second queen is
 * N−2. For the third queen, we won't attempt to place it in 2 columns already
 * occupied by the first 2 queens, and there must be at least two squares
 * attacked diagonally from the first 2 queens. Thus, the maximum number of
 * squares we can consider for the third queen is N−4. This pattern continues,
 * giving an approximate time complexity of N! at the end.
 * 
 * Space complexity: O(N), where N is the number of queens (which is the same as
 * the width and height of the board).
 * 
 * Extra memory used includes the 3 sets used to store board state, as well as
 * the recursion call stack. All of this scales linearly with the number of
 * queens.
 * 
 */
public class NQueens {

	int size;

	public int totalNQueens(int n) {
		size = n;
		Set<Integer> colSet = new HashSet<>();
		Set<Integer> diagSet = new HashSet<>();
		Set<Integer> aDiagSet = new HashSet<>();
		return backTrack(0, colSet, diagSet, aDiagSet);
	}

	public int backTrack(int row, Set<Integer> colSet, Set<Integer> diagSet, Set<Integer> aDiagSet) {
		if (size == row)
			return 1;
		int solution = 0;
		for (int col = 0; col < size; col++) {
			int diag = row - col;
			int aDiag = row + col;
			if (colSet.contains(col) || diagSet.contains(diag) || aDiagSet.contains(aDiag)) {
				continue;
			}
			colSet.add(col);
			diagSet.add(diag);
			aDiagSet.add(aDiag);
			solution = solution + backTrack(row + 1, colSet, diagSet, aDiagSet);

			colSet.remove(col);
			diagSet.remove(diag);
			aDiagSet.remove(aDiag);
		}
		return solution;
	}

}

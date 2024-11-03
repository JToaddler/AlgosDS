package leetcode.matrix;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/01-matrix/
 * 
 * Time complexity: O(m⋅n)
 * 
 * The BFS never visits a node more than once due to seen. Each node has at most
 * 4 neighbors, so the work done at each node is O(1). This gives us a time
 * complexity of O(m⋅n), the number of nodes.
 * 
 * Space complexity: O(m⋅n)
 * 
 */
public class DistanceToZero {
	public int[][] updateMatrix(int[][] mat) {
		int m = mat.length;
		int n = mat[0].length;
		int[][] res = new int[m][n];
		boolean[][] seen = new boolean[m][n];
		Queue<State> que = new LinkedList<>();
		int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
		for (int row = 0; row < m; row++) {
			for (int col = 0; col < n; col++) {
				if (mat[row][col] == 0) {
					que.add(new State(row, col, 0));
					seen[row][col] = true;
				}
			}
		}
		while (!que.isEmpty()) {
			State s = que.poll();
			int row = s.row, col = s.col, state = s.state;
			for (int[] dir : directions) {
				int r = row + dir[0];
				int c = col + dir[1];
				if (isValid(r, c, mat) && !seen[r][c]) {
					seen[r][c] = true;
					que.add(new State(r, c, state + 1));
					res[r][c] = state + 1;
				}
			}
		}
		return res;
	}

	public boolean isValid(int r, int c, int[][] mat) {
		return r >= 0 && c >= 0 && r < mat.length && c < mat[r].length;
	}

	public static void main(String[] args) {

	}

}

class State {
	int row;
	int col;
	int state;

	State(int r, int c, int s) {
		this.row = r;
		this.col = c;
		this.state = s;
	}
}

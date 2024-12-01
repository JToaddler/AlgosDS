package leetcode.graph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * https://leetcode.com/problems/minimum-obstacle-removal-to-reach-corner
 * 
 * 
 */
public class MinimumObstaclesToRemove {

	public static final int[][] directions = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };

	public static void main(String[] args) {
		int[][] grid = { { 0, 1, 1 }, { 1, 1, 0 }, { 1, 1, 0 } };
		System.out.println(minimumObstacles(grid));
	}

	/**
	 * Approach : 0-1 Breadth-First Search (BFS)
	 * 
	 * Time complexity: O(m⋅n)
	 * 
	 * Each of the m⋅n cells in the grid is visited exactly once because we only
	 * process unvisited cells. The deque operations are all O(1).
	 * 
	 * Thus, the total time complexity is O(m⋅n).
	 * 
	 * Space complexity: O(m⋅n)
	 * 
	 * The minObstacles array and the deque both take O(m⋅n) space. All other
	 * variables take constant space.
	 * 
	 * Thus, the space complexity remains O(m⋅n).
	 * 
	 */

	public static int minimumObstacles(int[][] grid) {
		int rowCount = grid.length;
		int colCount = grid[0].length;

		int[][] minObst = new int[rowCount][colCount];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				minObst[i][j] = Integer.MAX_VALUE;
			}
		}
		minObst[0][0] = 0;
		Deque<int[]> deque = new ArrayDeque<>();
		deque.add(new int[] { 0, 0, 0 });

		while (!deque.isEmpty()) {
			int[] removed = deque.poll();
			int obst = removed[0];
			int row = removed[1];
			int col = removed[2];
			for (int[] dir : directions) {
				int newRow = dir[0] + row;
				int newCol = dir[1] + col;
				if (isWithInBoundary(grid, newRow, newCol) && minObst[newRow][newCol] == Integer.MAX_VALUE) {
					if (grid[newRow][newCol] == 1) {
						int obstCount = obst + 1;
						minObst[newRow][newCol] = obst + 1;
						deque.addLast(new int[] { obstCount, newRow, newCol });
					} else {
						minObst[newRow][newCol] = obst;
						deque.addFirst(new int[] { obst, newRow, newCol });
					}
				}
			}
		}
		for (int[] row : grid)
			System.out.println(Arrays.toString(row));
		System.out.println("===");
		for (int[] row : minObst)
			System.out.println(Arrays.toString(row));
		return minObst[rowCount - 1][colCount - 1];
	}

	public static boolean isWithInBoundary(int[][] grid, int row, int col) {
		int rowLen = grid.length;
		int colLen = grid[0].length;
		if (rowLen > row && colLen > col && row >= 0 && col >= 0)
			return true;
		return false;
	}

}

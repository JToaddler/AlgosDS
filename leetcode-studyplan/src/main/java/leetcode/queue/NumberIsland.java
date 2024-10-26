package leetcode.queue;

import java.util.LinkedList;
import java.util.Queue;

public class NumberIsland {

	public static void main(String[] args) {

		char[][] grid = { { '1', '1', '1', '1', '0' }, { '1', '1', '0', '1', '0' }, { '1', '1', '0', '0', '0' },
				{ '0', '0', '0', '0', '0' } };
		System.out.println(numIslands_DFS(grid));

	}

	/*
	 * Time complexity : O(M×N) where M is the number of rows and N is the number of
	 * columns.
	 * 
	 * Space complexity : O(min(M,N)) because in worst case where the grid is filled
	 * with lands, the size of queue can grow up to min(M,N).
	 * 
	 */
	public int numIslands_BFS(char[][] grid) {
		int[][] direction = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
		int count = 0;
		for (int row = 0; row < grid.length; row++) {
			for (int col = 0; col < grid[row].length; col++) {
				if (grid[row][col] == '1') {
					count += 1;
					Queue<int[]> queue = new LinkedList<>();
					queue.add(new int[] { row, col });
					while (!queue.isEmpty()) {
						int[] point = queue.poll();
						int r = point[0];
						int c = point[1];
						for (int[] dir : direction) {
							int x = dir[0] + r;
							int y = dir[1] + c;
							if (x < 0 || y < 0 || x >= grid.length || y >= grid[x].length)
								continue;
							if (grid[x][y] == '1') {
								grid[x][y] = '0';
								queue.add(new int[] { x, y });
							}
						}
					}
				}
			}
		}
		return count;
	}

	// find the total number of island using DFS search
	/*
	 * Time complexity : O(M×N) where M is the number of rows and N is the number of
	 * columns.
	 * 
	 * Space complexity : worst case O(M×N) in case that the grid map is filled with
	 * lands where DFS goes by M×N deep.
	 */
	public static int numIslands_DFS(char[][] grid) {
		int count = 0;
		for (int row = 0; row < grid.length; row++) {
			for (int col = 0; col < grid[row].length; col++) {
				if (grid[row][col] == '1') {
					count += 1;
					dfs(grid, row, col);
				}
			}
		}
		return count;
	}

	public static void dfs(char[][] grid, int row, int col) {
		if (row < 0 || col < 0 || row >= grid.length || col >= grid[row].length || grid[row][col] == '0') {
			return;
		}
		grid[row][col] = '0';
		dfs(grid, row + 1, col);
		dfs(grid, row - 1, col);
		dfs(grid, row, col + 1);
		dfs(grid, row, col - 1);
	}
}

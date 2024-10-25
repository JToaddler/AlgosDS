package leetcode.queue;

import java.util.Queue;
import java.util.LinkedList;

/**
 * 
 * https://leetcode.com/problems/walls-and-gates/editorial/
 * 
 */
public class WallsAndGates_BF {

	private static final int EMPTY = Integer.MAX_VALUE;
	private static final int GATE = 0;
	final int[][] direction = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	// optimized - stack/BFS - start identifying gate and fill empty rooms
	/*
	 * Time complexity : O(mn).
	 * 
	 * If you are having difficulty to derive the time complexity, start simple.
	 * 
	 * Let us start with the case with only one gate. The breadth-first search takes
	 * at most m×n steps to reach all rooms, therefore the time complexity is O(mn).
	 * But what if you are doing breadth-first search from k gates?
	 * 
	 * Once we set a room's distance, we are basically marking it as visited, which
	 * means each room is visited at most once. Therefore, the time complexity does
	 * not depend on the number of gates and is O(mn).
	 * 
	 * Space complexity : O(mn). The space complexity depends on the queue's size.
	 * We insert at most m×n points into the queue.
	 */
	public void wallsAndGates_Stack(int[][] rooms) {
		int m = rooms.length;
		int n = rooms[0].length;
		Queue<int[]> queue = new LinkedList<>();
		for (int row = 0; row < rooms.length; row++) {
			for (int col = 0; col < rooms[row].length; col++) {
				if (rooms[row][col] == GATE) {
					queue.add(new int[] { row, col });
				}
			}
		}
		while (!queue.isEmpty()) {
			int[] point = queue.poll();
			int row = point[0];
			int col = point[1];
			for (int[] dir : direction) {
				int r = row + dir[0];
				int c = col + dir[1];
				if (r < 0 || c < 0 || r >= m || c >= n || rooms[r][c] != EMPTY) {
					continue;
				}
				rooms[r][c] = rooms[row][col] + 1;
				queue.add(new int[] { r, c });
			}
		}
	}

	// Brute force - start BFS from empty rooms
	// TC - O(m^2 n^2)
	// SC - O(mn)
	public void wallsAndGates_BF(int[][] rooms) {

		for (int row = 0; row < rooms.length; row++) {
			for (int col = 0; col < rooms[row].length; col++) {
				if (rooms[row][col] == EMPTY) {
					rooms[row][col] = distanceToNearestGate(rooms, row, col);
				}
			}
		}

	}

	public int distanceToNearestGate(int[][] rooms, int startRow, int startCol) {
		int m = rooms.length;
		int n = rooms[0].length;
		int[][] distance = new int[m][n];
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { startRow, startCol });
		while (!queue.isEmpty()) {
			int[] point = queue.poll();
			int row = point[0];
			int col = point[1];
			for (int[] dir : direction) {
				int r = dir[0] + row;
				int c = dir[1] + col;
				if (r < 0 || c < 0 || r >= m || c >= n || rooms[r][c] == -1 || distance[r][c] != 0) {
					continue;
				}
				distance[r][c] = distance[row][col] + 1;
				if (rooms[r][c] == 0) {
					return distance[r][c];
				}
				queue.add(new int[] { r, c });
			}
		}
		return EMPTY;
	}

}

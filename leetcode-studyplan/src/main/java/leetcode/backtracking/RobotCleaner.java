package leetcode.backtracking;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/robot-room-cleaner/
 * 
 * Time complexity : O(N−M), where N is a number of cells in the room and M is a
 * number of obstacles.
 * 
 * We visit each non-obstacle cell once and only once. At each visit, we will
 * check 4 directions around the cell. Therefore, the total number of operations
 * would be 4⋅(N−M). Space complexity : O(N−M), where N is a number of cells in
 * the room and M is a number of obstacles.
 * 
 * We employed a hashtable to keep track of whether a non-obstacle cell is
 * visited or not.
 */
public class RobotCleaner {

	int[][] directions = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	Set<Pair<Integer, Integer>> set = new HashSet<>();
	Robot bot;

	public void cleanRoom(Robot robot) {
		this.bot = robot;
		backTrack(0, 0, 0);
	}

	public void backTrack(int row, int col, int dir) {
		set.add(new Pair<Integer, Integer>(row, col));
		bot.clean();

		for (int i = 0; i < 4; ++i) {
			int newDir = (dir + i) % 4;
			int newRow = row + directions[newDir][0];
			int newCol = col + directions[newDir][1];

			if (!set.contains(new Pair<Integer, Integer>(newRow, newCol)) && bot.move()) {
				backTrack(newRow, newCol, newDir);
				goBack();
			}
			bot.turnRight();
		}
	}

	public void goBack() {
		bot.turnRight();
		bot.turnRight();
		bot.move();
		bot.turnRight();
		bot.turnRight();
	}

}

class Pair<T, S> {
	T x;
	S y;

	public Pair(T x, S y) {
		super();
		this.x = x;
		this.y = y;
	}

}

interface Robot {
	// Returns true if the cell in front is open and robot moves into the cell.
	// Returns false if the cell in front is blocked and robot stays in the current
	// cell.
	public boolean move();

	// Robot will stay in the same cell after calling turnLeft/turnRight.
	// Each turn will be 90 degrees.
	public void turnLeft();

	public void turnRight();

	// Clean the current cell.
	public void clean();
}
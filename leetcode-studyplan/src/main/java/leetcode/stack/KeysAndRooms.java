package leetcode.stack;

import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/keys-and-rooms/
 * 
 * Time Complexity: O(N+E), where N is the number of rooms, and E is the total
 * number of keys.
 * 
 * 
 * Space Complexity: O(N) in additional space complexity, to store stack and
 * seen.
 */
public class KeysAndRooms {

	public static void main(String[] args) {

	}

	public boolean canVisitAllRooms(List<List<Integer>> rooms) {
		boolean[] seen = new boolean[rooms.size()];
		Stack<Integer> stack = new Stack<>();
		stack.add(0);
		seen[0] = true;
		while (!stack.isEmpty()) {
			Integer x = stack.pop();
			for (Integer child : rooms.get(x)) {
				if (!seen[child]) {
					seen[child] = true;
					stack.add(child);
				}
			}
		}
		for (boolean isVisited : seen)
			if (!isVisited)
				return false;
		return true;
	}
}

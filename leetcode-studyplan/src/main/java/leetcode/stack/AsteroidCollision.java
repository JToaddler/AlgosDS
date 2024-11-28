package leetcode.stack;

import java.util.Stack;

/**
 * https://leetcode.com/problems/asteroid-collision/description/
 * 
 * Time complexity: O(N).
 * 
 * We iterate over each asteroid in the list, and for each asteroid, we might
 * iterate over the asteroids we have in the stack and keep popping until they
 * explode. The important point is that each asteroid can be added and removed
 * from the stack only once. Therefore, each asteroid can be processed only
 * twice, first when we iterate over it and then again while popping it from the
 * stack. Therefore, the total time complexity is equal to O(N).
 * 
 * 
 * Space complexity: O(N).
 * 
 * The only space required is for the stack; the maximum number of asteroids
 * that could be there in the stack is N when there is no asteroid collision.
 * The final list that we return, remainingAsteroids, is used to store the
 * output, which is generally not considered part of space complexity. Hence,
 * the total space complexity equals O(N).
 * 
 * 
 */
public class AsteroidCollision {

	public static void main(String[] args) {
		asteroidCollision(new int[] { 10, 2, 3, 4, -5, });
	}

	public static int[] asteroidCollision(int[] asteroids) {
		Stack<Integer> stack = new Stack<>();
		for (int ast : asteroids) {
			boolean isAdd = true;
			while (!stack.isEmpty() && stack.peek() > 0 && ast < 0) {
				if (Math.abs(stack.peek()) < Math.abs(ast)) {
					stack.pop();
					continue;
				} else if (Math.abs(stack.peek()) == Math.abs(ast)) {
					stack.pop();
					isAdd = false;
					break;
				} else if (Math.abs(stack.peek()) > Math.abs(ast)) {
					isAdd = false;
					break;
				}
			}
			if (isAdd)
				stack.add(ast);
		}
		int[] res = new int[stack.size()];
		for (int i = res.length - 1; i >= 0; i--) {
			res[i] = stack.pop();
		}
		return res;
	}

}

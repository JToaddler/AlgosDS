package leetcode.queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GenerateBrackets {

	public static void main(String[] args) {
		generateParenthesis(3);
	}

	private static boolean isValid(String pString) {
		int leftCount = 0;
		for (char p : pString.toCharArray()) {
			if (p == '(') {
				leftCount++;
			} else {
				leftCount--;
			}

			if (leftCount < 0) {
				return false;
			}
		}
		return leftCount == 0;
	}

	public static List<String> generateParenthesis(int n) {
		List<String> answer = new ArrayList<>();
		Queue<String> queue = new LinkedList<>(Arrays.asList(""));

		while (!queue.isEmpty()) {
			String curString = queue.poll();

			// If the length of curString is 2 * n, add it to `answer` if
			// it is valid.
			if (curString.length() == 2 * n) {
				if (isValid(curString)) {
					answer.add(curString);
				}
				continue;
			}
			queue.add(curString + ")");
			queue.add(curString + "(");
		}
		System.out.println(answer);
		return answer;
	}

}

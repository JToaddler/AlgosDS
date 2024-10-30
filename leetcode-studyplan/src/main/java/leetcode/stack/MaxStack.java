package leetcode.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * refer {@link MinStack}
 * 
 */
public class MaxStack {

	List<int[]> stack = new ArrayList<>();
	int count = 0;

	public MaxStack() {

	}

	public void push(int val) {
		if (count == 0) {
			stack.add(new int[] { val, val });
			count++;
			return;
		}
		int currentMax = stack.get(count - 1)[1];
		stack.add(new int[] { val, Math.max(val, currentMax) });
		count++;
	}

	public void pop() {
		if (count != 0) {
			stack.remove(count - 1);
			count--;
		}
	}

	public int top() {
		return stack.get(count - 1)[0];
	}

	public int getMax() {
		return stack.get(count - 1)[1];
	}

	public static void main(String[] args) {
		MaxStack s = new MaxStack();
		s.push(4);
		s.push(1);
		s.push(13);
		System.out.println(s.count);
		System.out.println(s.getMax());
		s.pop();
		System.out.println(s.count);
		System.out.println(s.getMax());
		System.out.println(s.top());
	}

}

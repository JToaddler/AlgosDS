package leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class StackUsingQueue {

	Deque<Integer> que = new ArrayDeque<>();

	public StackUsingQueue() {

	}

	public void push(int x) {
		que.addFirst(x);
	}

	public int pop() {
		return que.removeFirst();
	}

	public int top() {
		return que.getFirst();
	}

	public boolean empty() {
		return que.isEmpty();
	}
}

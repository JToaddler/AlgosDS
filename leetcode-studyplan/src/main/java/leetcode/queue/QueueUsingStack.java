package leetcode.queue;

import java.util.Stack;

public class QueueUsingStack {

	Stack<Integer> stack = new Stack<>();
	int count = 0;

	public void push(int x) {
		stack.add(x);
		count++;
	}

	public int pop() {
		Stack<Integer> temp = new Stack<>();
		while (!stack.isEmpty()) {
			temp.add(stack.pop());
		}
		int x = temp.pop();
		while (!temp.isEmpty()) {
			stack.add(temp.pop());
		}
		count--;
		return x;
	}

	public int peek() {
		Stack<Integer> temp = new Stack<>();
		while (!stack.isEmpty()) {
			temp.add(stack.pop());
		}
		int x = temp.peek();
		while (!temp.isEmpty()) {
			stack.add(temp.pop());
		}
		return x;
	}

	public boolean empty() {
		return count == 0;
	}

	public static void main(String[] args) {
		QueueUsingStack q = new QueueUsingStack();
		q.push(3);
		q.push(7);
		q.push(9);
		System.out.println(q.empty());
		System.out.println("Peek :" + q.peek());
		System.out.println("Peek :" + q.pop());
		System.out.println("Peek :" + q.peek());
		System.out.println("Peek :" + q.pop());
		q.push(19);
		System.out.println("Peek :" + q.peek());

	}

}

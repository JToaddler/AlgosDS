package com.ds.queue;

import java.util.Stack;

/**
 * 
 * https://leetcode.com/problems/implement-queue-using-stacks/
 * 
 * 
 * 
 * 
 * @author Anto
 *
 */
public class QueueStack {

	Stack<Integer> input = new Stack<Integer>();
	Stack<Integer> output = new Stack<Integer>();

	public void push(int x) {
		input.push(x);
	}

	public int pop() {
		peek();
		return output.pop();
	}

	public int peek() {
		if (output.isEmpty()) {
			while (!input.isEmpty()) {
				output.push(input.pop());
			}
		}
		return output.peek();
	}

	public boolean empty() {
		return input.isEmpty() && output.isEmpty();
	}

	public static void main(String[] args) {

		QueueStack qs = new QueueStack();

		qs.push(1);
		qs.push(3);
		qs.push(5);
		qs.push(7);

		System.out.println(qs.input);

		System.out.println(qs.pop());
		System.out.println(qs.pop());
		System.out.println(qs.pop());
		System.out.println(qs.pop());
	}
}

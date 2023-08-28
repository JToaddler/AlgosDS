package com.ds.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/implement-stack-using-queues
 * 
 * @author Anto
 *
 */
public class StackQueue {
	class MyStack {

		Queue<Integer> q1 = new LinkedList<Integer>();

		public MyStack() {

		}

		public void push(int x) {
			q1.add(x);
			int size = q1.size();
			while (size > 1) {
				q1.add(q1.remove());
				size--;
			}
			System.out.println("Added : " + x + " Queue : " + q1);
		}

		public int pop() {
			int x = q1.remove();
			System.out.println("Removed : " + x + " Queue : " + q1);
			return x;
		}

		public int top() {
			return q1.peek();
		}

		public boolean empty() {
			return q1.isEmpty();
		}
	}

	public static void main(String[] args) {
		MyStack sq = new StackQueue().new MyStack();
		sq.push(3);
		sq.push(9);
		sq.push(11);
		sq.push(2);
		sq.pop();
		sq.pop();
	}
}

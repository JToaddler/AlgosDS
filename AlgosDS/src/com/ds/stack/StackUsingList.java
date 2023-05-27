package com.ds.stack;

import java.util.LinkedList;

public class StackUsingList {

	public static void main(String[] args) {

		StackUsingList main = new StackUsingList();

		Stack<Integer> stack = main.new Stack<Integer>();

		stack.add(1);
		stack.add(2);
		stack.add(3);
		stack.add(4);

		System.out.println(stack.list);

		System.out.println(stack.pop() + " " + stack.pop());
	}

	class Stack<E> {

		private LinkedList<E> list;

		public Stack() {
			list = new LinkedList<E>();
		}

		public void add(E e) {
			this.list.addFirst(e);
		}

		public void push(E e) {
			this.list.addFirst(e);
		}

		public E peek() {
			return list.peek();
		}

		public E pop() {
			return list.pop();
		}

		public boolean isEmpty() {
			return list.isEmpty();
		}

		public int size() {
			return list.size();
		}

	}

}

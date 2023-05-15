package com.ds;

import java.util.Arrays;

/**
 * 
 * <p>
 * <code>
 * https://www.geeksforgeeks.org/introduction-to-stack-data-structure-and-algorithm-tutorials/
 * all operations are O(1) as pointer in the stack always points to last/top of
 * the stack. Operations Complexity 
 * push() 		O(1) 
 * pop() 		O(1) 
 * isEmpty() 	O(1) 
 * size() 		O(1)
 * </code>
 * </p>
 * 
 * 
 * @author Anto
 *
 */
public class Stack {

	private int array[];
	private int top;
	private int capacity;

	public Stack(int size) {
		this.array = new int[size];
		this.capacity = size;
		this.top = -1;
	}

	public boolean push(int x) {
		if (this.isFull()) {
			System.out.println("Stack full");
			return false;
		}
		this.array[++top] = x;
		return true;
	}

	public int pop() {
		if (this.isEmpty()) {
			System.out.println("Stack is empty");
			throw new ArrayIndexOutOfBoundsException();
		}
		int i = array[top];
		array[top] = 0;
		--top;
		return i;
	}

	public int getSize() {
		return top + 1;
	}

	public Boolean isEmpty() {
		return top == -1;
	}

	public Boolean isFull() {
		return top == capacity - 1;
	}

	public void printStack() {
		for (int i = 0; i <= top; i++) {
			System.out.print(array[i] + ", ");
		}
	}

	@Override
	public String toString() {
		return "Stack [array=" + Arrays.toString(array) + ", top=" + top + ", capacity=" + capacity + "]";
	}

	public static void main(String[] args) {

		Stack stack = new Stack(3);
		stack.push(23);
		stack.push(56);
		stack.push(67);
		System.out.println(stack.push(66));
		System.out.println(stack.getSize());
		System.out.println(stack.pop());
		System.out.println(stack);

	}
}
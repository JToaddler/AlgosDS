package leetcode.stack;

import java.util.ArrayList;
import java.util.List;


public class MyStack {

	private List<Integer> data = new ArrayList<>();
	int count = 0;

	public boolean push(Integer a) {
		count++;
		return data.add(a);
	}

	public Integer pop() {
		if (isEmpty())
			throw new IllegalStateException("Stack is Empty");
		count--;
		return data.removeLast();
	}

	public boolean isEmpty() {
		return count == 0;
	}

	public int count() {
		return count;
	}

	public static void main(String[] args) {
		MyStack stack = new MyStack();
		System.out.println(stack.count);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		System.out.println(stack.data);
		System.out.println(stack.count);
		System.out.println(stack.pop());
		System.out.println(stack.data);
		System.out.println(stack.pop());
		System.out.println(stack.count);
		System.out.println(stack.pop());
		System.out.println(stack.isEmpty());
		System.out.println(stack.data);
	}
}

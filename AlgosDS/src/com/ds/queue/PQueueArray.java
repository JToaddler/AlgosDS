package com.ds.queue;

/**
 * 
 * https://www.tutorialspoint.com/dsa_using_java/dsa_using_java_priority_queue.htm#
 * 
 * @author Anto
 *
 */
public class PQueueArray {

	private int MAX;
	private int[] items;
	private int size;

	public PQueueArray(int capacity) {
		MAX = capacity;
		items = new int[MAX];
		size = 0;
	}

	public void insert(int data) {
		int i = 0;
		for (i = size - 1; i >= 0; i--) {
			if (data > items[i]) {
				items[i + 1] = items[i];
			} else {
				break;
			}
		}
		items[i + 1] = data;
		size++;
	}

	public void print() {
		for (int i : items) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	public int poll() {
		int val = items[size - 1];
		items[size - 1] = 0;
		size--;
		return val;
	}

	public int peek() {
		return items[size - 1];
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean isFull() {
		return MAX == size;
	}

	public int size() {
		return size;
	}

	public static void main(String[] args) {
		PQueueArray queue = new PQueueArray(6);
		// insert 5 items
		queue.insert(3);
		queue.insert(5);
		queue.insert(9);
		queue.insert(1);
		queue.insert(12);
		queue.insert(4);
		queue.print();
		System.out.println("Peek :" + queue.peek());
		System.out.println("poll :" + queue.poll());
		System.out.println("poll :" + queue.poll());
		System.out.println("Peek :" + queue.peek());
	}

}

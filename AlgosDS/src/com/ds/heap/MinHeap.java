package com.ds.heap;

import java.util.Arrays;

/**
 * 
 * https://codegym.cc/groups/posts/min-heap-in-java
 * 
 * @author Anto
 *
 */
public class MinHeap {

	private int[] heap;
	private int size;

	public MinHeap(int capacity) {
		heap = new int[capacity];
	}

	public MinHeap() {
		this(5);
	}

	public int parent(int index) {
		return (index - 1) / 2;
	}

	public int leftChild(int index) {
		return (2 * index) + 1;
	}

	public int rightChild(int index) {
		return (2 * index) + 2;
	}

	public boolean isLeaf(int index) {
		return (index > size / 2) && index <= size;
	}

	public void add(int val) {
		if (heap.length == size) {
			System.out.println("Min Heap Priority Queue is full");
			return;
		}
		heap[size] = val;
		int current = size;
		while (heap[current] < heap[parent(current)]) {
			swap(current, parent(current));
			current = parent(current);
		}
		size++;
		System.out.println("After Insert :" + Arrays.toString(heap));
	}

	public int pop() {

		int popped = heap[0];
		heap[0] = heap[--size];
		minHeapify(0);
		heap[size] = Integer.MAX_VALUE;
		System.out.println("After pop :" + Arrays.toString(heap));
		return popped;
	}

	public void minHeapify(int index) {
		if (isLeaf(index))
			return;
		if (heap[index] > heap[leftChild(index)] || heap[index] > heap[rightChild(index)]) {
			if (heap[leftChild(index)] < heap[rightChild(index)]) {
				swap(index, leftChild(index));
				minHeapify(leftChild(index));
			} else {
				swap(index, rightChild(index));
				minHeapify(rightChild(index));
			}
		}
	}

	public int peek() {
		return heap[0];
	}

	public void swap(int index1, int index2) {
		int temp = heap[index1];
		heap[index1] = heap[index2];
		heap[index2] = temp;
	}

	public void print() {
		for (int i = 0; i < size / 2; i++) {
			System.out.print("Parent Node : " + heap[i]);

			if (leftChild(i) < size) {
				System.out.print("   Left Child : " + heap[leftChild(i)]);
			}
			if (rightChild(i) < size) {
				System.out.println("  Right Child : " + heap[rightChild(i)]);
			}
		}
	}

	public static void main(String[] args) {

		MinHeap minHeap = new MinHeap();
		minHeap.add(12);
		minHeap.add(10);
		minHeap.add(11);
		minHeap.add(8);
		minHeap.add(9);
		minHeap.add(7);
		minHeap.pop();
		minHeap.pop();

	}
}

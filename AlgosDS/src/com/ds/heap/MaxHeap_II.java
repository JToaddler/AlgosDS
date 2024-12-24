package com.ds.heap;

import java.util.Arrays;

public class MaxHeap_II {

	private int size;
	private Integer[] heap;

	public MaxHeap_II(int capacity) {
		this.heap = new Integer[capacity];
	}

	public void swap(int index1, int index2) {
		int temp = heap[index1];
		heap[index1] = heap[index2];
		heap[index2] = temp;
	}

	public boolean isLeaf(int index) {
		return index <= size && index > size / 2;
	}

	public int leftChild(int index) {
		return (index * 2) + 1;
	}

	public int rightChild(int index) {
		return (index * 2) + 2;
	}

	public int parent(int index) {
		return (index - 1) / 2;
	}

	public void add(int val) {
		if (size >= heap.length) {
			System.out.println("heap size full");
			return;
		}
		heap[size] = val;
		int current = size;
		while (heap[current] > heap[parent(current)]) {
			swap(current, parent(current));
			current = parent(current);
		}
		size++;
	}

	public int peek() {
		return heap[0];
	}

	public int poll() {
		if (size <= 0) {
			throw new RuntimeException("Empty Heap");
		}
		int popped = heap[0];
		heap[0] = heap[size - 1];
		heap[size - 1] = null;
		size--;
		maxHeapify(0);
		return popped;
	}

	public void maxHeapify(int index) {
		int left = index * 2 + 1;
		int right = index * 2 + 2;
		int parent = index;
		if (left < this.size && heap[left] != null && heap[parent] < heap[left]) {
			parent = left;
		}
		if (left < this.size && heap[right] != null && heap[parent] < heap[right]) {
			parent = right;
		}
		if (parent != index) {
			int temp = heap[index];
			heap[index] = heap[parent];
			heap[parent] = temp;
			maxHeapify(parent);
		}

	}

	public void print() {
		String str = Arrays.toString(this.heap);
		System.out.println(str);
	}

	public static void main(String[] args) {

		MaxHeap_II maxHeap = new MaxHeap_II(5);
		maxHeap.add(4);
		maxHeap.add(2);
		maxHeap.print();
		maxHeap.add(5);
		maxHeap.add(1);
		maxHeap.add(6);
		maxHeap.print();
		maxHeap.add(8);
		System.out.println(maxHeap.poll());
		System.out.println(maxHeap.poll());
		System.out.println(maxHeap.poll());
		System.out.println(maxHeap.poll());
		System.out.println(maxHeap.poll());
		System.out.println(maxHeap.poll());
		maxHeap.print();
	}

}

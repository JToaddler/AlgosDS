package com.ds.heap;

import java.util.Arrays;

/**
 * 
 * 
 * @author Anto 
 *
 */
public class MaxHeap {

	private int[] heap;
	private int size;

	public MaxHeap(int maxSize) {
		this.heap = new int[maxSize];
	}

	public boolean isLeaf(int index) {
		return index > size / 2 && index <= size;
	}

	public int parent(int index) {
		return (index - 1) / 2;
	}

	public int leftChild(int index) {
		return (index * 2) + 1;
	}

	public int rightChild(int index) {
		return (index * 2) + 2;
	}

	/**
	 * Insert new element to the max heap
	 * 
	 * @param val
	 * 
	 */
	public void add(int val) {

		if (size >= heap.length) {
			System.err.println("Max Heap Priority Queue is full");
			return;
		}

		heap[size] = val;
		int current = size;
		while (heap[current] > heap[parent(current)]) {
			swap(current, parent(current));
			current = parent(current);
		}
		size++;
		System.out.println("After Insert :" + Arrays.toString(heap));
	}

	public void swap(int index1, int index2) {
		int temp = heap[index1];
		heap[index1] = heap[index2];
		heap[index2] = temp;
	}

	public int poll() {

		int popped = heap[0];
		heap[0] = heap[--size];
		heap[size] = Integer.MIN_VALUE;
		maxHeapify(0);
		System.out.println("After Extracting max " + popped + " : " + Arrays.toString(heap));
		return popped;
	}

	public int peek() {
		return heap[0];
	}

	public void maxHeapify(int index) {
		if (isLeaf(index))
			return;
		if (heap[index] < heap[leftChild(index)] || heap[index] < heap[rightChild(index)]) {
			if (heap[leftChild(index)] < heap[rightChild(index)]) {
				swap(index, rightChild(index));
				maxHeapify(rightChild(index));
			} else {
				swap(index, leftChild(index));
				maxHeapify(leftChild(index));
			}
		}
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

		MaxHeap mHeap = new MaxHeap(5);
		mHeap.add(20);
		mHeap.add(25);
		mHeap.add(12);
		mHeap.add(27);
		mHeap.add(2);
		mHeap.add(12);
		mHeap.print();
		mHeap.poll();
		mHeap.poll();

	}

}

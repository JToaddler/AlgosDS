package leetcode.queue;

import java.util.Arrays;

class MyCircularQueue_1 {

	int[] queue;
	int capacity;
	int head = 0;
	int count;

	public MyCircularQueue_1(int k) {
		this.capacity = k;
		queue = new int[k];
		count = 0;
	}

	public boolean enQueue(int value) {
		if (count == capacity)
			return false;
		else {
			queue[(head + count) % capacity] = value;
			count++;
			return true;
		}
	}

	public boolean deQueue() {
		if (count == 0)
			return false;
		else {
			head = (head + 1) % capacity;
			count--;
			return true;
		}
	}

	public int Front() {
		return count == 0 ? -1 : queue[head];
	}

	public int Rear() {
		if (count == 0)
			return -1;
		int tail = (head + count - 1) % capacity;
		return queue[tail];
	}

	public boolean isEmpty() {
		return count == 0;
	}

	public boolean isFull() {
		return capacity == count;
	}

	public static void main(String[] args) {
		MyCircularQueue_1 que = new MyCircularQueue_1(3);
		que.enQueue(1);
		que.enQueue(2);
		que.enQueue(3);
		que.enQueue(4);
		System.out.println(Arrays.toString(que.queue));
		System.out.println(que.Rear());
		System.out.println(que.isFull());
		System.out.println(que.deQueue());
		System.out.println(que.enQueue(4));
		System.out.println(que.Rear());

	}

}
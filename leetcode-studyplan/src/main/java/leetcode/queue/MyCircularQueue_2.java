package leetcode.queue;

import java.util.LinkedList;
import java.util.List;

/**
 * There is nothing 'circular about this implementation.
 */
public class MyCircularQueue_2 {

	List<Integer> que;
	int capacity;
	int count = 0;

	public MyCircularQueue_2(int k) {
		this.que = new LinkedList<>();
		this.capacity = k;
	}

	public boolean enQueue(int value) {
		if (isFull())
			return false;
		else {
			que.add(value);
			count++;
			return true;
		}
	}

	public boolean deQueue() {
		if (isEmpty())
			return false;
		else {
			que.removeFirst();
			count--;
			return true;
		}
	}

	public int Front() {

		return count == 0 ? -1 : que.getFirst();
	}

	public int Rear() {
		return count == 0 ? -1 : que.getLast();
	}

	public boolean isEmpty() {
		return count == 0;
	}

	public boolean isFull() {
		return count == capacity;
	}

	public static void main(String[] args) {
		MyCircularQueue_2 que = new MyCircularQueue_2(6);
		que.enQueue(6);
		que.Rear();
		que.Rear();
		que.deQueue();
		que.enQueue(5);
		que.Rear();
		que.deQueue();
		que.Front();
		que.deQueue();
		que.deQueue();
		que.deQueue();

	}
}

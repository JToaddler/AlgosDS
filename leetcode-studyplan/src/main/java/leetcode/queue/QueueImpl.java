package leetcode.queue;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

interface Queue<T> {

	public boolean enqueue(T t);

	public T dequeue();

	public int size();

	public boolean isEmpty();

}

public class QueueImpl implements Queue<Integer> {

	List<Integer> list = new ArrayList<>();
	int size = 0;
	int head;

	public static void main(String[] args) {
		QueueImpl que = new QueueImpl();
		que.enqueue(1);
		que.enqueue(2);
		que.enqueue(3);
		System.out.println(que.isEmpty());
		System.out.println(que);
		que.dequeue();
		que.dequeue();
		que.dequeue();
		que.dequeue();
		System.out.println(que);
		System.out.println(que.isEmpty());
	}

	@Override
	public boolean enqueue(Integer i) {
		head++;
		size++;
		return list.add(i);
	}

	@Override
	public Integer dequeue() {

		if (size == 0) {
			throw new NoSuchElementException("queue is empty");
		}

		int a = list.remove(head - 1);
		head--;
		size--;
		return a;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size > 0 ? false : true;
	}

	@Override
	public String toString() {
		return "QueueImpl [list=" + list + ", size=" + size + ", head=" + head + "]";
	}

}

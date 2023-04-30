package com.ds.queue;

public class QueueLinkedList {

	Node head;
	Node tail;
	int size;

	private class Node {
		Object val;
		Node next;

		public Node(int data, Node next) {
			this.val = data;
			this.next = next;
		}

	}

	public boolean enQueue(int data) {
		Node newNode = new Node(data, null);
		if (isEmpty()) {
			head = newNode;
		} else {
			tail.next = newNode;
		}
		tail = newNode;
		size++;
		return true;
	}

	public Object deQueue() {
		if (isEmpty()) {
			throw new IndexOutOfBoundsException("Can not deQueue from empty queue");
		}
		Object item = head.val;
		head = head.next;
		size--;
		return item;
	}

	public Object peek() {
		if (isEmpty()) {
			throw new IndexOutOfBoundsException("Can not deQueue from empty queue");
		}
		return head.val;
	}

	public boolean isEmpty() {
		return size == 0 ? true : false;
	}

	public int size() {
		return size;
	}

	public void printQueue() {
		Node current = head;
		while (current != null) {
			System.out.print(current.val + " ");
			current = current.next;
		}
		System.out.println();
	}

	public boolean contains(Object data) {
		return this.indexOf(data) >= 0 ? true : false;
	}

	public int indexOf(Object data) {
		if (isEmpty()) {
			return -1;
		}
		Node current = head;
		for (int i = 0; i < size && current != null; i++) {
			if (current.val == data) {
				return i;
			}
			current = current.next;
		}
		return -1;
	}

	public static void main(String[] args) {
		
		QueueLinkedList queue = new QueueLinkedList();
		queue.enQueue(1);
		queue.enQueue(2);
		queue.enQueue(3);
		queue.enQueue(4);
		queue.printQueue();
		queue.deQueue();
		queue.deQueue();
		queue.deQueue();
		queue.deQueue();
		queue.enQueue(1);
		queue.enQueue(10);
		queue.enQueue(23);
		queue.enQueue(45);
		queue.printQueue();
		System.out.println("Peek " + queue.peek());
		System.out.println("Peek " + queue.peek());
		System.out.println(queue.indexOf(45));
		System.out.println(queue.contains(23));
		queue.printQueue();
		
	}

}
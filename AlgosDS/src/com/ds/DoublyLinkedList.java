package com.ds;

public class DoublyLinkedList {

	private int size;
	private Node head;
	private Node tail;

	public class Node {

		private int data;
		private Node previous;
		private Node next;

		public Node(int data) {
			this.data = data;
		}
	}

	/**
	 * O(1)
	 */
	public void addFirst(int value) {

		Node newNode = new Node(value);
		if (head == null) {
			head = newNode;
			tail = newNode;
		} else {
			head.previous = newNode;
			newNode.next = head;
			newNode.previous = null;
			head = newNode;
		}
		++size;

	}

	/**
	 * O(1)
	 * 
	 * @param value
	 */
	public void addLast(int value) {

		Node newNode = new Node(value);
		if (head == null) { // no items in the Dllinked
			head = newNode;
			tail = newNode;
		} else {
			tail.next = newNode;
			newNode.previous = tail;
			tail = newNode;
			newNode.next = null;
		}
		++size;
	}

	public void traverseBackward() {
		if (tail != null) {
			Node current = tail;
			while (current != null) {
				System.out.print(current.data + " ");
				current = current.previous;
			}
		} else {
			System.out.print("[]");
		}
		System.out.println();
	}

	public void traverseForward() {
		if (head != null) {
			Node current = head;
			while (current != null) {
				System.out.print(current.data + " ");
				current = current.next;
			}
		} else {
			System.out.print("[]");
		}
		System.out.println();
	}

	/**
	 * O(i) - i - Index . On the average its O(n)
	 * 
	 * @param val
	 * @param index
	 */
	public void insertAtPosition(int val, int index) {

		if (index == 0) {
			addFirst(val);
		} else if (index == size) {
			addLast(val);
		} else {
			Node newNode = new Node(val);
			Node current = head;
			for (int i = 0; i < index; i++) {
				current = current.next;
			}
			Node previous = current.previous;
			previous.next = newNode;
			newNode.previous = previous;
			newNode.next = current;
			current.previous = newNode;
			++size;
		}

	}

	/**
	 * 
	 */
	public int searchByIndex(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("");
		}
		Node current = head;
		for (int i = 0; i < index; i++) {
			current = current.next;
		}
		return current.data;
	}

	public int searchByValue(int val) {

		if (head == null) {
			return -1;
		}
		Node current = head;
		for (int i = 0; i < size; i++) {
			if (current.data == val) {
				return i;
			}
			current = current.next;
		}
		return -1;
	}

	public void deleteFromHead() {

		if (head == null) {
			return;
		}
		head = head.next;
		head.previous = null;
		--size;
	}

	public void deleteFromTail() {

		if (tail == null) {
			return;
		}
		tail = tail.previous;
		tail.next = null;
		--size;
	}

	public void deleteByIndex(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("out of range");
		}
		Node nodeToBeDelted = head;
		for (int i = 0; i < index; i++) {
			nodeToBeDelted = nodeToBeDelted.next;
		}
		Node previous = nodeToBeDelted.previous;
		Node next = nodeToBeDelted.next;
		previous.next = next;
		next.previous = previous;
		--size;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void print() {
		if (head == null) {
			System.out.println("[]");
		} else {
			Node curr = head;
			while (curr != null) {
				System.out.print(curr.data + " ");
				curr = curr.next;
			}
		}
		System.out.println();
	}

	void reverse() {
		Node temp = null;
		Node current = head;

		/*
		 * swap next and prev for all nodes of doubly linked list
		 */
		while (current != null) {
			temp = current.previous;
			current.previous = current.next;
			current.next = temp;
			current = current.previous;
		}

		/*
		 * Before changing head, check for the cases like empty list and list with only
		 * one node
		 */
		if (temp != null) {
			head = temp.previous;
		}
	}

	public static void main(String[] args) {

		DoublyLinkedList dlist = new DoublyLinkedList();

		dlist.addLast(8);
		dlist.addLast(9);
		dlist.addFirst(7);

		dlist.addFirst(6);
		dlist.addFirst(5);
		dlist.addFirst(4);

		System.out.println("traverseForward ->");
		dlist.traverseForward();

		System.out.println("traverseBackward ->");
		dlist.traverseBackward();

		dlist.deleteFromHead();
		dlist.deleteFromTail();

		System.out.println("---------");
		dlist.traverseForward();
		dlist.traverseBackward();
		System.out.println("---------");

		System.out.println("Size :" + dlist.size());
		System.out.println("Print()->");
		System.out.println("searchByIndex(0) : " + dlist.searchByIndex(0));
		System.out.println("searchByValue(7) : " + dlist.searchByValue(7));
		dlist.print();
		dlist.deleteByIndex(2);
		dlist.print();
		dlist.insertAtPosition(7, 2);
		dlist.print();
	}

}

package com.ds.linkedlist;

class MyLinkedList {

	Node head;
	int count = 0;

	public MyLinkedList() {
		head = new Node(0);
	}

	public int get(int index) {
		if (index < 0 || index >= count)
			return -1;
		Node cur = head;
		for (int i = 0; i < index + 1; i++)
			cur = cur.next;
		return cur.val;
	}

	public void addAtHead(int val) {
		addAtIndex(0, val);
	}

	public void addAtTail(int val) {
		addAtIndex(count, val);
	}

	public void addAtIndex(int index, int val) {
		if (index > count)
			return;
		if (index < 0)
			index = 0;
		count += 1;
		Node cur = head;
		Node newNode = new Node(val);
		for (int i = 0; i < index; i++) {
			cur = cur.next;
		}
		newNode.next = cur.next;
		cur.next = newNode;
	}

	public void deleteAtIndex(int index) {
		if (index < 0 || index >= count)
			return;
		Node cur = head;
		count -= 1;
		for (int i = 0; i < index; i++) {
			cur = cur.next;
		}
		cur.next = cur.next.next;

	}
}

class Node {
	int val;
	Node next;

	public Node(int v) {
		this.val = v;
	}

	public Node(int v, Node nextNode) {
		this.val = v;
		next = nextNode;
	}
}

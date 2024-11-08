package leetcode.linkedlist;

import leetcode.model.DoublyListNode;

public class MyDoublyLinkedList {

	DoublyListNode head;

	public void addAtHead(int val) {
		DoublyListNode cur = new DoublyListNode(val);
		cur.next = head;
		if (head != null) {
			head.prev = cur;
		}
		head = cur;
	}

	public void addAtTail(int val) {
		if (head == null) {
			addAtHead(val);
			return;
		}
		DoublyListNode cur = new DoublyListNode(val);
		DoublyListNode tail = getTail();
		tail.next = cur;
		cur.prev = tail;
		tail = cur;
	}

	public DoublyListNode getTail() {
		DoublyListNode cur = head;
		while (cur != null && cur.next != null) {
			cur = cur.next;
		}
		return cur;
	}

	public void addAtIndex(int index, int val) {
		if (head == null) {
			addAtHead(val);
			return;
		}
		DoublyListNode prev = getNode(index - 1);
		if (prev == null)
			return;
		DoublyListNode cur = new DoublyListNode(val);
		DoublyListNode next = prev.next;

		prev.next = cur;
		cur.prev = prev;
		cur.next = next;

		if (next != null) {
			next.prev = cur;
		}
	}

	public void deleteNode(int index) {
		DoublyListNode cur = getNode(index);
		if (cur == null)
			return;
		DoublyListNode prev = cur.prev;
		DoublyListNode next = cur.next;
		if (prev == null) {
			head = next;
		} else {
			prev.next = next;
		}
		if (next != null) {
			next.prev = prev;
		}
	}

	public DoublyListNode getNode(int index) {
		DoublyListNode cur = head;
		for (int i = 0; i < index && cur != null; i++) {
			cur = cur.next;
		}
		return cur;
	}

}

package com.leetcode.linkedlist;

public class RotateLinkedList {

	public ListNode rotateRight(ListNode head, int k) {
		int size = 1;
		ListNode dummy = head;
		while (dummy.next != null) {
			dummy = dummy.next;
			size++;
		}
		System.out.println("Size : " + size);
		k = k % size;

		dummy.next = head;
		dummy = head;
		for (int i = 0; i < size - k - 1; i++) {
			dummy = dummy.next;
		}
		System.out.println(dummy.val);
		head = dummy.next;
		dummy.next = null;
		return head;
	}

	public static void main(String[] args) {
		RotateLinkedList list = new RotateLinkedList();
		ListNode head = list.new ListNode(1);
		head.next = list.new ListNode(2);
		head.next.next = list.new ListNode(3);
		head.next.next.next = list.new ListNode(4);
		head.next.next.next.next = list.new ListNode(5);
		ListNode node = list.rotateRight(head, 12);
		System.out.println(node);
	}

	public class ListNode {
		@Override
		public String toString() {
			return val + "," + next;
		}

		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}
}

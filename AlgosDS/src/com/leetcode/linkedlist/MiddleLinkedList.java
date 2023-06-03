package com.leetcode.linkedlist;

public class MiddleLinkedList {

	public static ListNode middleNode(ListNode head) {

		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		System.out.println(slow);
		return slow;
	}

	public static void main(String[] args) {

		ListNode node = new ListNode();

		node.insert(1);
		node.insert(2);
		node.insert(3);
		node.insert(4);
		node.insert(5);
		node.insert(6);
		node.insert(7);
		node.insert(8);
		middleNode(node);

	}
}

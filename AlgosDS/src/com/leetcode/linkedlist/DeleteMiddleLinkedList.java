package com.leetcode.linkedlist;

public class DeleteMiddleLinkedList {
	public ListNode deleteMiddle(ListNode head) {
		if (head.next == null)
			return null;

		ListNode current = head;
		ListNode nextNode = head.next.next;
		while (nextNode != null && nextNode.next != null) {
			current = current.next;
			nextNode = nextNode.next.next;
		}
		current.next = current.next.next;
		return head;
	}
}

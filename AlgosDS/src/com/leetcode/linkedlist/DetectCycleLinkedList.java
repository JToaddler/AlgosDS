package com.leetcode.linkedlist;

public class DetectCycleLinkedList {

	public static class ListNode {

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

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(5);
		head.next.next = new ListNode(8);
		head.next.next.next = new ListNode(12);
		head.next.next.next.next = head;
		System.out.println(new DetectCycleLinkedList().hasCycle(head));
	}

	public boolean hasCycle(ListNode node) {
		if (node == null || node.next == null)
			return false;
		ListNode slow = node, fast = node;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast)
				return true;
		}
		return false;
	}

}

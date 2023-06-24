package com.leetcode.linkedlist;

import java.util.HashSet;
import java.util.Set;

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
		head.next.next.next.next = new ListNode(5);
		System.out.println(new DetectCycleLinkedList().hasCycle(head));
		System.out.println(new DetectCycleLinkedList().hasCycle2(head));
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

	public boolean hasCycle2(ListNode head) {
		if (head == null)
			return false;
		Set<ListNode> set = new HashSet<ListNode>();
		ListNode current = head;
		while (current != null) {
			current = current.next;
			if (set.contains(current))
				return true;
			else
				set.add(current);
		}
		return false;
	}

}

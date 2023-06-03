package com.leetcode.scratchpad;

public class ListNode {

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

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append("val :" + this.val + ", ").append("[ ").append(this.val);
		if (next == null) {
			sb.append(" ]");
		} else {
			ListNode current = this.next;
			while (current.next != null) {
				sb.append(", ").append(current.val);
				current = current.next;
			}
			sb.append(", " + current.val).append(" ]");
		}
		return sb.toString();
	}

	public void insert(int val) {
		ListNode node = new ListNode(val);
		if (this.next == null) {
			this.next = node;
		} else {
			ListNode current = next;
			while (current.next != null) {
				current = current.next;
			}
			current.next = node;
		}
	}

}

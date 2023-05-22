package com.leetcode.linkedlist;

/**
 * Pending
 * 
 * @author Anto
 *
 */
public class MergeSortedLinkedList {

	public static void main(String[] args) {
		
	}

}

class ListNode {

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

	public void insert(int val) {

		if (next == null) {
			next = new ListNode(val);
		} else {
			ListNode current = next;
			while (current != null) {

				current = current.next;

			}

		}

	}

}
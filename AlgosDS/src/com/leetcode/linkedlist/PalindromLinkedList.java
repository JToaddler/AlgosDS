package com.leetcode.linkedlist;

public class PalindromLinkedList {

	public boolean isPalindrome(ListNode head) {

		if (head == null || head.next == null)
			return true;
		ListNode midNode = findMidNode(head);
		ListNode secondHalf = reverse(midNode.next);

		ListNode p1 = head;
		ListNode p2 = secondHalf;
		boolean result = true;
		while (result && p2 != null) {
			result = p2.val == p1.val ? true : false;
			p1 = p1.next;
			p2 = p2.next;
		}
		midNode.next = reverse(secondHalf);
		System.out.println(head);
		return result;
	}

	public ListNode reverse(ListNode node) {

		ListNode current = node;
		ListNode next = null;
		ListNode previous = null;
		while (current != null) {
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		System.out.println("After reverse : " + previous);
		return previous;
	}

	public ListNode findMidNode(ListNode head) {
		ListNode current = head;
		ListNode nextNode = head;
		while (nextNode.next != null && nextNode.next.next != null) {
			current = current.next;
			nextNode = nextNode.next.next;
		}
		System.out.println("Mid Node:" + current);
		return current;
	}

	public static void main(String[] args) {

		ListNode node = new ListNode(1);
		node.insert(2);


		PalindromLinkedList pTest = new PalindromLinkedList();
		System.out.println("Result : " + pTest.isPalindrome(node));

	}
}

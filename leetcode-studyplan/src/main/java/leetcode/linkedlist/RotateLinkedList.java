package leetcode.linkedlist;

import leetcode.model.ListNode;

/**
 * https://leetcode.com/problems/rotate-list
 * 
 * Complexity Analysis
 * 
 * Time complexity : O(N) where N is a number of elements in the list.
 * 
 * Space complexity : O(1) since it's a constant space solution.
 * 
 */
public class RotateLinkedList {

	public static void main(String[] args) {

		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);
		ListNode node7 = new ListNode(7);

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		System.out.println(rotateRight(node1, 0));
	}

	public static ListNode rotateRight(ListNode head, int k) {
		if (head == null || head.next == null || k == 0)
			return head;
		int size = 1;
		ListNode tail = head;
		for (; tail.next != null; size++)
			tail = tail.next;
		// size - k => for right rotation.
		// k => for left rotation
		int index = size - (k % size);
		if (index == 0 || index == size) //
			return head;
		tail.next = head; // this forms a circular linked list
		ListNode newTail = head;
		for (int j = 1; j < index; j++) {
			newTail = newTail.next;
		}
		ListNode node = newTail.next;
		newTail.next = null;
		return node;
	}

}

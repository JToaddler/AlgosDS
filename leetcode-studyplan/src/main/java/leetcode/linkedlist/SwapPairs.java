package leetcode.linkedlist;

import leetcode.Recursion;
import leetcode.model.ListNode;

/**
 * https://leetcode.com/problems/swap-nodes-in-pairs
 * 
 */
public class SwapPairs implements Recursion {

	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		System.out.println(node1);
		ListNode node = swapPairs(node1);
		// swapPairs_recursion(node1);
		System.out.println(node);
	}

	public static ListNode swapPairs_recursion(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode first = head;
		ListNode sec = head.next;
		first.next = swapPairs(sec.next);
		sec.next = first;
		return sec;
	}

	public static ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode prev = dummy;
		while (head != null && head.next != null) {

			ListNode first = head;
			ListNode sec = head.next;

			first.next = sec.next;
			sec.next = first;
			prev.next = sec;

			prev = first;
			head = first.next;
		}
		return dummy.next;
	}

}

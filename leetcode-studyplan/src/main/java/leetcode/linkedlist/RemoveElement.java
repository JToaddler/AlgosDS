package leetcode.linkedlist;

import leetcode.model.ListNode;

public class RemoveElement {

	public static void main(String[] args) {

		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(2);
		ListNode node4 = new ListNode(3);
		ListNode node5 = new ListNode(2);
		ListNode node6 = new ListNode(2);

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		ListNode node = removeElements_BF_Not_Optimized(node1, 2);
		ListNode cur = node;
		while (cur != null) {
			System.out.println(cur.val);
			cur = cur.next;
		}
	}

	public static ListNode removeElements_Optimized(ListNode head, int val) {
		ListNode sentinel = new ListNode(0);
		sentinel.next = head;

		ListNode prev = sentinel, curr = head;
		while (curr != null) {
			if (curr.val == val)
				prev.next = curr.next;
			else
				prev = curr;
			curr = curr.next;
		}
		return sentinel.next;
	}

	public static ListNode removeElements_BF_Not_Optimized(ListNode head, int val) {
		ListNode dummy = new ListNode(0);
		ListNode temp = dummy;
		ListNode cur = head;
		while (cur != null) {
			if (cur.val != val) {
				temp.next = new ListNode(cur.val);
				temp = temp.next;
			}
			cur = cur.next;
		}
		return dummy.next;
	}

}

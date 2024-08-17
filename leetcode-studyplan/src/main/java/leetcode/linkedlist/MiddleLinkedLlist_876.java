package leetcode.linkedlist;

import leetcode.input.ArrayBuilder;
import leetcode.input.LinkedListBuilder;
import leetcode.model.ListNode;

public class MiddleLinkedLlist_876 {

	public ListNode middleNode(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		System.out.println(slow.val);
		return slow;
	}

	public static void main(String[] args) {
		MiddleLinkedLlist_876 obj = new MiddleLinkedLlist_876();
		ListNode node = LinkedListBuilder.buildLinkedList(ArrayBuilder.buildArray(5));
		obj.middleNode(node);
	}
}

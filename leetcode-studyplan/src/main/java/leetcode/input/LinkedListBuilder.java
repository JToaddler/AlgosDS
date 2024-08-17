package leetcode.input;

import leetcode.model.ListNode;

public class LinkedListBuilder {

	public static void main(String[] args) {
		int[] nums = ArrayBuilder.buildArray(5);
		ListNode node = buildLinkedList(nums);
		ListNode temp = node;
		while (temp != null) {
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
	}

	public static ListNode buildLinkedList(int[] nums) {
		ListNode head = new ListNode(nums[0]);
		ListNode current = head;
		for (int i = 1; i < nums.length; i++) {
			current.next = new ListNode(nums[i]);
			current = current.next;
		}
		return head;
	}
}

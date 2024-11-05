package leetcode.linkedlist;

/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 * 
 */
public class RemoveNthFromEnd {

	public static void main(String[] args) {

	}

	/*
	 * Time complexity : O(L).
	 * 
	 * The algorithm makes one traversal of the list of L nodes. Therefore time
	 * complexity is O(L).
	 * 
	 * Space complexity : O(1).
	 */
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode first = dummy;
		ListNode second = dummy;
		for (int i = 1; i <= n + 1; i++) {
			first = first.next;
		}
		while (first != null) {
			first = first.next;
			second = second.next;
		}
		second.next = second.next.next;
		return dummy.next;
	}

}

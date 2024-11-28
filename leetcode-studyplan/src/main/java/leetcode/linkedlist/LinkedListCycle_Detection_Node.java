package leetcode.linkedlist;

import java.util.HashSet;
import java.util.Set;

import leetcode.model.ListNode;

/**
 * https://leetcode.com/problems/linked-list-cycle-ii/description/
 * 
 */
public class LinkedListCycle_Detection_Node {

	public static void main(String[] args) {

	}

	/*
	 * Optimized - Floyd's Tortoise and Hare Algorithm
	 * 
	 * Time Complexity - Time complexity: O(n). The algorithm consists of two
	 * phases. In the first phase, we use two pointers (the "hare" and the
	 * "tortoise") to traverse the list. The slow pointer (tortoise) will go through
	 * the list only once until it meets the hare. Therefore, this phase runs in
	 * O(n) time.
	 * 
	 * In the second phase, we again have two pointers traversing the list at the
	 * same speed until they meet. The maximum distance to be covered in this phase
	 * will not be greater than the length of the list (recall that the hare just
	 * needs to get back to the entrance of the cycle). So, this phase also runs in
	 * O(n) time.
	 * 
	 * 
	 * Space Complexity - O(1)
	 * 
	 */
	public ListNode detectCycle(ListNode head) {
		if (head == null || head.next == null)
			return null;
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				break;
			}
		}
		if (fast == null || fast.next == null)
			return null;
		fast = head;
		while (fast != slow) {
			fast = fast.next;
			slow = slow.next;
		}
		return slow;
	}

	/*
	 * 
	 * Time complexity: O(n).
	 * 
	 * Space complexity: O(n).
	 * 
	 */
	public ListNode detectCycle_HashSet(ListNode head) {
		if (head == null || head.next == null)
			return null;
		Set<ListNode> set = new HashSet<>();
		ListNode cur = head;
		while (cur != null) {
			if (set.contains(cur))
				return cur;
			set.add(cur);
			cur = cur.next;
		}
		return null;
	}

}

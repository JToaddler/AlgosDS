package leetcode.linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/linked-list-cycle/
 * 
 */
public class LinkedListCycleDetection {

	/**
	 * Time complexity : O(n). when no cycle
	 * 
	 * Time complexity : O(n + k) when there is a cycle
	 * 
	 * 
	 * Space complexity : O(1).
	 */
	public boolean hasCycle_FordAlgorithm(ListNode head) {
		if (head == null || head.next == null)
			return false;
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast)
				return true;
		}
		return false;
	}

	/**
	 * Time complexity : O(n). We visit each of the n elements in the list at most
	 * once. Adding a node to the hash table costs only O(1) time.
	 * 
	 * Space complexity: O(n). The space depends on the number of elements added to
	 * the hash table, which contains at most n elements.
	 */
	public boolean hasCycle_BF(ListNode head) {
		if (head == null || head.next == null)
			return false;
		ListNode cur = head;
		Set<ListNode> set = new HashSet<>();
		while (cur != null) {
			if (set.contains(cur))
				return true;
			set.add(cur);
			cur = cur.next;
		}
		return false;
	}

}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

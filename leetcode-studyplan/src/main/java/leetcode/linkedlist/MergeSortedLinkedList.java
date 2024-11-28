package leetcode.linkedlist;

import leetcode.model.ListNode;

/**
 * https://leetcode.com/problems/merge-two-sorted-lists/
 * 
 * Time complexity : O(n+m)
 * 
 * Because exactly one of l1 and l2 is incremented on each loop iteration, the
 * while loop runs for a number of iterations equal to the sum of the lengths of
 * the two lists. All other work is constant, so the overall complexity is
 * linear.
 * 
 * Space complexity : O(1)
 * 
 * The iterative approach only allocates a few pointers, so it has a constant
 * overall memory footprint.
 */
public class MergeSortedLinkedList {

	/**
	 * Time complexity : O(n+m)
	 * 
	 * Because exactly one of l1 and l2 is incremented on each loop iteration, the
	 * while loop runs for a number of iterations equal to the sum of the lengths of
	 * the two lists. All other work is constant, so the overall complexity is
	 * linear.
	 * 
	 * Space complexity : O(1)
	 */
	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		if (list1 == null)
			return list2;
		if (list2 == null)
			return list1;
		ListNode node = new ListNode(0);
		ListNode prev = node;
		while (list1 != null && list2 != null) {
			if (list1.val > list2.val) {
				prev.next = list2;
				list2 = list2.next;
			} else {
				prev.next = list1;
				list1 = list1.next;
			}
			prev = prev.next;
		}
		prev.next = list1 != null ? list1 : list2;
		return node.next;
	}

	public ListNode mergeTwoLists_recursion(ListNode list1, ListNode list2) {
		if (list1 == null)
			return list2;
		if (list2 == null)
			return list1;
		if (list1.val > list2.val) {
			list2.next = mergeTwoLists(list1, list2.next);
			return list2;
		} else {
			list1.next = mergeTwoLists(list1.next, list2);
			return list1;
		}
	}

}

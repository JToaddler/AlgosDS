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
	 *
	 */
	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		if (list1 == null)
			return list2;
		if (list2 == null)
			return list1;
		ListNode node = new ListNode(0);
		ListNode cur = node;
		while (list1 != null & list2 != null) {
			if (list1.val > list2.val) {
				cur.next = new ListNode(list2.val);
				list2 = list2.next;
			} else {
				cur.next = new ListNode(list1.val);
				list1 = list1.next;
			}
			cur = cur.next;
		}
		cur.next = list1 != null ? list1 : list2;
		return node.next;
	}

}

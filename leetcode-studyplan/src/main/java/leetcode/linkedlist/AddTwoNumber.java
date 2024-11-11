package leetcode.linkedlist;

import leetcode.model.ListNode;

/**
 * https://leetcode.com/problems/add-two-numbers/
 * 
 * Complexity Analysis
 * 
 * Time complexity : O(max(m,n)). Assume that m and n represents the length of
 * l1 and l2 respectively, the algorithm above iterates at most max(m,n) times.
 * 
 * 
 * Space complexity : O(1). The length of the new list is at most max(m,n)+1
 * However, we don't count the answer as part of the space complexity.
 */
public class AddTwoNumber {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode sentinel = new ListNode(0);
		ListNode cur = sentinel;
		int carry = 0;
		while (l1 != null || l2 != null) {
			int x = l1 != null ? l1.val : 0;
			int y = l2 != null ? l2.val : 0;
			int sum = x + y + carry;
			int digit = sum % 10;
			carry = sum / 10;
			cur.next = new ListNode(digit);
			cur = cur.next;
			l1 = l1 != null ? l1.next : null;
			l2 = l2 != null ? l2.next : null;
		}
		if (carry > 0)
			cur.next = new ListNode(carry);
		return sentinel.next;
	}

}

package leetcode.linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/intersection-of-two-linked-lists/
 * 
 */
public class IntersectionNode {

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null)
			return null;
		ListNode curA = headA;
		ListNode curB = headB;
		Set<ListNode> seen = new HashSet<>();
		while (curA != null || curB != null) {

			if (curA != null)
				if (seen.contains(curA)) {
					return curA;
				} else {
					seen.add(curA);
					curA = curA.next;
				}

			if (curB != null)
				if (seen.contains(curB)) {
					return curB;
				} else {
					seen.add(curB);
					curB = curB.next;
				}
		}
		return null;
	}
}

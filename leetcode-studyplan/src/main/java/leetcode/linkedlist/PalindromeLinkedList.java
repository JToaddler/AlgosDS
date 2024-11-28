package leetcode.linkedlist;

import leetcode.model.ListNode;

/**
 * Brute force solution : Deep copy the original LinkedList and reverse the
 * copy. Start comparing original nodes with copy nodes.</br>
 * 
 * TC : O(N)
 * 
 * SC : O(N)
 * 
 * </br>
 * Optimized solution:
 * 
 * Find the end of 1st half. reverse from (end of 1st half).next => 2nd half
 * reversed.
 * 
 * Start comparing the 2nd half & original linkedlist.
 * 
 * After iteration : reverse from end of 1st half. this will make the original
 * head intact.</br>
 * 
 * TC : O(4N) => O(N)
 * 
 * SC : O(1)
 * 
 */
public class PalindromeLinkedList {

	public static void main(String[] args) {

		ListNode node = new ListNode(1, new ListNode(2));
		System.out.println(isPalindrome(node));

	}

	public static boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null)
			return true;
		ListNode firstHalfEnd = endOfFirstHalf(head);
		ListNode sec = reverse(firstHalfEnd.next);
		ListNode cur2 = sec;
		ListNode cur1 = head;
		boolean result = true;
		while (result && cur2 != null) {
			if (cur1.val != cur2.val)
				result = false;
			cur1 = cur1.next;
			cur2 = cur2.next;
		}
		firstHalfEnd.next = reverse(sec);
		return result;
	}

	public static ListNode endOfFirstHalf(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	public static ListNode clone(ListNode head) {
		ListNode sentinel = new ListNode(0);
		ListNode temp = sentinel;
		ListNode cur = head;
		while (cur != null) {
			temp.next = new ListNode(cur.val);
			temp = temp.next;
			cur = cur.next;
		}
		return sentinel.next;
	}

	public static ListNode reverse(ListNode head) {
		ListNode prev = null;
		ListNode cur = head;
		while (cur != null) {
			ListNode temp = cur.next;
			cur.next = prev;
			prev = cur;
			cur = temp;
		}
		return prev;
	}

}

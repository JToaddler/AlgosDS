package leetcode.linkedlist;

public class ReverseLinkedList {

	public static void main(String[] args) {

	}

	public ListNode reverseList_Optiomized(ListNode head) {
		if (head == null || head.next == null)
			return head;
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

	/**
	 * 
	 * TC - O(N)
	 * 
	 * SP - O(N) - this can be improved to O(1). its creating new objects for node
	 * in the list.
	 * 
	 * @return
	 */
	public ListNode reverseList_Not_Optimized(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode list = null;
		ListNode cur = head;
		while (cur != null) {
			ListNode node = new ListNode(cur.val);
			if (list == null) {
				list = node;
			} else {
				node.next = list;
				list = node;
			}
			cur = cur.next;
		}
		return list;
	}

}
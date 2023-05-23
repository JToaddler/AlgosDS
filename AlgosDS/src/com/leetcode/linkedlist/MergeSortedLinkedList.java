package com.leetcode.linkedlist;

/**
 * Pending
 * 
 * @author Anto
 *
 */
public class MergeSortedLinkedList {

	public ListNode mergeLinkedList(ListNode list1, ListNode list2) {

		if (list1 == null)
			return list2;
		if (list2 == null)
			return list1;
		ListNode node = new ListNode(0);
		ListNode next = node;

		while (list1 != null && list2 != null) {

			if (list1.val > list2.val) {
				next.next = new ListNode(list2.val);
				list2 = list2.next;
			} else {
				next.next = new ListNode(list1.val);
				list1 = list1.next;
			}
			next = next.next;
		}
		next.next = list1 != null ? list1 : list2;
		return node.next;
	}

	public ListNode compareInsert(ListNode list1, ListNode list2, ListNode node) {

		if (list1.val < list2.val) {
			node.val = list1.val;
			node.next = new ListNode(list2.val);
		} else {
			node.val = list2.val;
			node.next = new ListNode(list1.val);
		}
		return node.next;
	}

	public static void main(String[] args) {
		ListNode node1 = new ListNode(5);
		node1.insert(12);
		node1.insert(34);
		node1.insert(56);

		ListNode node2 = new ListNode(3);
		node2.insert(11);
		node2.insert(39);
		node2.insert(46);

		ListNode mergedList = new MergeSortedLinkedList().mergeLinkedList(node1, node2);
		System.out.println(mergedList);
	}

}

class ListNode {

	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append("val :" + this.val + ", ").append("[ ").append(this.val);
		if (next == null) {
			sb.append(" ]");
		} else {
			ListNode current = this.next;
			while (current.next != null) {
				sb.append(", ").append(current.val);
				current = current.next;
			}
			sb.append(", " + current.val).append(" ]");
		}
		return sb.toString();
	}

	public void insert(int val) {
		ListNode node = new ListNode(val);
		if (this.next == null) {
			this.next = node;
		} else {
			ListNode current = next;
			while (current.next != null) {
				current = current.next;
			}
			current.next = node;
		}
	}

}

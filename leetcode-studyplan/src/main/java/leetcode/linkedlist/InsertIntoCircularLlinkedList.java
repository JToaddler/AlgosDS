package leetcode.linkedlist;

import leetcode.linkedlist.model.Node;

/**
 * https://leetcode.com/problems/insert-into-a-sorted-circular-linked-list/description/
 * 
 * 
 */
public class InsertIntoCircularLlinkedList {

	public static void main(String[] args) {

//		Node node1 = new Node(1);
//		Node node2 = new Node(2);
//		Node node3 = new Node(3);
//		Node node4 = new Node(4);
//		Node node5 = new Node(5);
//		Node node6 = new Node(6);
//		Node node7 = new Node(7);
//
//		node4.next = node5;
//		node5.next = node6;
//		node6.next = node7;
//
//		node7.next = node1;
//		node1.next = node2;
//		node2.next = node3;
//		node3.next = node4;

		Node node1 = new Node(3);
		Node node2 = new Node(3);
		Node node3 = new Node(5);

		node1.next = node2;
		node2.next = node3;
		node3.next = node1;

		Node node = insert(node1, 0);
		System.out.println(node.val);
	}

	public static Node insert(Node head, int insertVal) {
		if (head == null) {
			Node node = new Node(insertVal);
			node.next = node;
			return node;
		}

		Node start = head.next;
		Node end = head;
		Node cur = head.next;
		while (cur != head) {
			if (cur.val > cur.next.val) {
				start = cur.next;
				end = cur;
				break;
			}
			cur = cur.next;
		}
		end.next = null;
		Node nd = start;
		while (nd != null) {
			if (nd.next == null) { // this is important
				Node node = new Node(insertVal);
				end.next = node;
				node.next = start;
				break;
			} else if (insertVal >= nd.val && insertVal <= nd.next.val) {
				Node next = nd.next;
				Node node = new Node(insertVal);
				nd.next = node;
				node.next = next;
				end.next = start;
				break;
			}
			nd = nd.next;
		}
		return head;
	}
}

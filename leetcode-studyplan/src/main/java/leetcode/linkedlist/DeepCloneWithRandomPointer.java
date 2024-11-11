package leetcode.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class DeepCloneWithRandomPointer {

	Map<Node1, Node1> map = new HashMap<Node1, Node1>();

	public Node1 copyRandomList(Node1 head) {
		if (head == null)
			return head;
		map.put(head, new Node1(head.val));
		Node1 temp = head;
		while (temp != null) {
			Node1 clone = cloneNode(temp);
			Node1 cloneRandom = cloneNode(temp.random);
			Node1 cloneNext = cloneNode(temp.next);
			clone.random = cloneRandom;
			clone.next = cloneNext;
			temp = temp.next;
		}
		return map.get(head);
	}

	public Node1 cloneNode(Node1 node) {
		if (node == null) {
			return null;
		}
		if (map.containsKey(node)) {
			return this.map.get(node);
		} else {
			map.put(node, new Node1(node.val));
			return map.get(node);
		}
	}

	/**
	 * Brute force
	 * 
	 * 2 Pass - iteration
	 * 
	 */
	public Node1 copyRandomList_BF(Node1 head) {

		Map<Node1, Node1> map = new HashMap<>();
		Node1 dummy = new Node1(0);
		Node1 temp = head;
		Node1 cur = dummy;
		while (temp != null) {
			cur.next = new Node1(temp.val);
			map.put(temp, cur.next);
			cur = cur.next;
			temp = temp.next;
		}
		temp = head;
		while (temp != null) {
			if (temp.random != null) {
				Node1 child = temp.random;
				Node1 cloneChild = map.get(child);
				Node1 clone = map.get(temp);
				clone.random = cloneChild;
			}
			temp = temp.next;
		}
		return dummy.next;
	}

}

class Node1 {
	int val;
	Node1 next;
	Node1 random;

	public Node1(int val) {
		this.val = val;
		this.next = null;
		this.random = null;
	}
}

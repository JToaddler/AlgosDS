package leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/n-ary-tree-level-order-traversal/
 * 
 * 
 */
public class NaryTreeLevelOrderTraversal {

	/*
	 * BFS using Queue Time complexity : O(n), where n is the number of nodes.
	 * 
	 * Each node is getting added to the queue, removed from the queue, and added to
	 * the result exactly once.
	 * 
	 * Space complexity : O(n).
	 * 
	 */
	public List<List<Integer>> levelOrder(Node root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null)
			return res;
		Queue<Node> que = new LinkedList<>();
		que.add(root);
		while (!que.isEmpty()) {
			List<Integer> list = new ArrayList<Integer>();
			int size = que.size();
			for (int i = 0; i < size; i++) {
				Node removed = que.poll();
				list.add(removed.val);
				if (removed.children != null)
					for (Node child : removed.children) {
						que.add(child);
					}
			}
			res.add(list);
		}
		return res;
	}
}

class Node {
	public int val;
	public List<Node> children;

	public Node() {
	}

	public Node(int _val) {
		val = _val;
	}

	public Node(int _val, List<Node> _children) {
		val = _val;
		children = _children;
	}
}

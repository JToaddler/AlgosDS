package leetcode.tree;

import leetcode.model.TreeNode;

/**
 * https://leetcode.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/description/
 * 
 * 
 */
public class BST_To_DLinkedList {

	/*
	 * // Definition for a Node. class Node { public int val; public Node left;
	 * public Node right;
	 * 
	 * public Node() {}
	 * 
	 * public Node(int _val) { val = _val; }
	 * 
	 * public Node(int _val,Node _left,Node _right) { val = _val; left = _left;
	 * right = _right; } };
	 */

	TreeNode first = null;
	TreeNode last = null;

	public TreeNode treeToDoublyList(TreeNode root) {
		if (root == null)
			return root;
		dfsInOrder(root);
		first.left = last;
		last.right = first;
		return first;
	}

	public void dfsInOrder(TreeNode node) {
		if (node == null)
			return;
		dfsInOrder(node.left);
		if (last != null) {
			last.right = node;
			node.left = last;
		} else {
			first = node;
		}
		last = node;
		dfsInOrder(node.right);
	}

}

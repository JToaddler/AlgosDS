package leetcode.tree;

import leetcode.model.TreeNode;

/**
 * https://leetcode.com/problems/delete-node-in-a-bst
 * 
 * 
 * 
 */
public class BST_deletion {

	/**
	 * 
	 * 
	 */
	public TreeNode deleteNode(TreeNode root, int key) {
		if (root == null)
			return null;

		if (root.val < key)
			root.right = deleteNode(root.right, key);
		else if (root.val > key)
			root.left = deleteNode(root.left, key);
		else {
			if (root.left == null && root.right == null)
				root = null;
			else if (root.right != null) {
				root.val = successor(root);
				root.right = deleteNode(root.right, root.val);
			} else {
				root.val = predecessor(root);
				root.left = deleteNode(root.left, root.val);
			}
		}
		return root;
	}

	public int successor(TreeNode node) {
		node = node.right;
		while (node.left != null) {
			node = node.left;
		}
		return node.val;
	}

	public int predecessor(TreeNode node) {
		node = node.left;
		while (node.right != null) {
			node = node.right;
		}
		return node.val;
	}
}

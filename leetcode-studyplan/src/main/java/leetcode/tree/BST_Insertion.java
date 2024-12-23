package leetcode.tree;

import leetcode.model.TreeNode;

/**
 * https://leetcode.com/problems/insert-into-a-binary-search-tree/
 * 
 */
public class BST_Insertion {

	/**
	 * Time complexity : O(H), where H is a tree height. That results in O(logN) in
	 * the average case, and O(N) in the worst case.
	 * 
	 * 
	 * Space complexity : O(1) since it's a constant space solution.
	 * 
	 */
	public TreeNode insertIntoBST(TreeNode root, int val) {
		TreeNode node = root;
		while (node != null) {
			if (node.val > val) {
				if (node.left == null) {
					node.left = new TreeNode(val);
					return root;
				}
				node = node.left;
			} else {
				if (node.right == null) {
					node.right = new TreeNode(val);
					return root;
				}
				node = node.right;
			}
		}
		return new TreeNode(val);
	}

	/**
	 * Time complexity : O(H), where H is a tree height. That results in O(logN) in
	 * the average case, and O(N) in the worst case.
	 *
	 * Space complexity : O(H) to keep the recursion stack, i.e. O(logN) in the
	 * average case, and O(N) in the worst case.
	 */
	public TreeNode insertIntoBST_recursion(TreeNode root, int val) {
		if (root == null)
			return new TreeNode(val);
		insert(root, val);
		return root;
	}

	public TreeNode insert(TreeNode node, int val) {
		if (node == null)
			return new TreeNode(val);
		if (node.val > val)
			node.left = insert(node.left, val);
		else
			node.right = insert(node.right, val);
		return node;
	}

}

package leetcode.tree;

import leetcode.model.TreeNode;

/**
 * https://leetcode.com/problems/balanced-binary-tree/description/
 */
public class HeightBalancedBinaryTree {

	public int height(TreeNode node) {
		if (node == null)
			return 0;
		return 1 + Math.max(height(node.left), height(node.right));
	}

	/**
	 * 
	 * Time complexity : O(nlogn)
	 * 
	 * Space complexity : O(n). The recursion stack may contain all nodes if the
	 * tree is skewed.
	 */
	public boolean isBalanced(TreeNode root) {
		if (root == null)
			return true;

		boolean isLeftBalanced = isBalanced(root.left);
		boolean isRightBalanced = isBalanced(root.right);
		int leftHeight = height(root.left);
		int rightHeight = height(root.right);
		return isLeftBalanced && isRightBalanced && Math.abs(leftHeight - rightHeight) < 2;
	}
}

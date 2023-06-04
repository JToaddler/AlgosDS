
package com.leetcode.tree;

public class BinaryTreeMaxDepth {

	public class TreeNode {

		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int val) {
			this.val = val;
		}
	}

	public int maxDepth(TreeNode root) {

		if (root == null) {
			return 0;
		}
		int left = maxDepth(root.left);
		int right = maxDepth(root.right);
		return Math.max(left, right) + 1;

	}

	public static void main(String[] args) {

	}

}

package com.leetcode.tree;

import java.util.Arrays;

public class HouseRobber3 {

	class TreeNode {
		@Override
		public String toString() {
			String leftStr = this.left != null ? "" + this.left.val : null;
			String rightStr = this.right != null ? "" + this.right.val : null;
			return "TreeNode [val=" + val + ", left=" + leftStr + ", right=" + rightStr + "]";
		}

		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}

		public void insert(TreeNode node, int val) {
			if (node.val > val) {
				TreeNode newNode = new TreeNode(val);
				if (node.left == null) {
					node.left = newNode;
					System.out.println("Value " + val + "  added to the left of " + node.val);
				} else
					insert(node.left, val);
			}
			if (node.val < val) {
				TreeNode newNode = new TreeNode(val);
				if (node.right == null) {
					node.right = newNode;
					System.out.println("Value " + val + "  added to the right of " + node.val);
				} else
					insert(node.right, val);
			}
			if (node.val == val)
				System.out.println(val + " already exists in Tree");
		}
	}

	public static int rob(TreeNode root) {
		int[] result = helper(root);
		System.out.println("Result : " + Arrays.toString(result) + ", Max Rob:" + Math.max(result[0], result[1]));
		return Math.max(result[0], result[1]);
	}

	public static int[] helper(TreeNode root) {
		if (root == null)
			return new int[] { 0, 0 };
		int[] left = helper(root.left);
		int[] right = helper(root.right);
		int withRoot = root.val + left[1] + right[1];
		int withOutRoot = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
		return new int[] { withRoot, withOutRoot };
	}

	public static void main(String[] args) {
		HouseRobber3 robber = new HouseRobber3();
		TreeNode tree = robber.new TreeNode(5);
		tree.insert(tree, 4);
		tree.insert(tree, 6);
		tree.insert(tree, 3);
		tree.insert(tree, 9);

		rob(tree);
	}

}

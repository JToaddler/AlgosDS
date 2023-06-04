package com.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

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

	public Integer[] levelOrderTraversal(TreeNode node) {

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(node);
		ArrayList<Integer> list = new ArrayList<Integer>();

		while (!queue.isEmpty()) {
			TreeNode removed = queue.remove();
			if (removed!=null) {
				if (removed.left != null)
					queue.add(removed.left);
				else
					queue.add(null);
				if (removed.right != null)
					queue.add(removed.right);
				else
					queue.add(null);
			}
			if (removed != null)
				list.add(removed.val);
			else
				list.add(null);
		}
		System.out.println(list);
		return list.toArray(Integer[]::new);
	}

	public static void main(String[] args) {
		HouseRobber3 robber = new HouseRobber3();
		TreeNode tree = robber.new TreeNode(50);
		tree.insert(tree, 45);
		tree.insert(tree, 65);

		tree.insert(tree, 35);
		tree.insert(tree, 48);

		tree.insert(tree, 55);
		tree.insert(tree, 75);
		tree.insert(tree, 70);
		tree.insert(tree, 80);
		robber.levelOrderTraversal(tree);
	}

}

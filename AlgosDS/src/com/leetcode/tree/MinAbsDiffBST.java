package com.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class MinAbsDiffBST {

	List<Integer> list = new ArrayList<>();

	TreeNode previousNode = null;
	int min = Integer.MAX_VALUE;

	static class TreeNode {
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
	}

	public void dfsInOrder(TreeNode root) {

		if (root == null)
			return;
		dfsInOrder(root.left);
		list.add(root.val);
		dfsInOrder(root.right);

	}

	public int getMinimumDifference_BF(TreeNode root) {
		dfsInOrder(root);
		System.out.println(list);
		int min = Integer.MAX_VALUE;
		for (int i = 1; i < list.size(); i++) {
			min = Math.min(min, list.get(i) - list.get(i - 1));
		}
		System.out.println(min);
		return min;
	}

	public void dfsInOrderOptimzed(TreeNode node) {
		if (node == null)
			return;
		dfsInOrderOptimzed(node.left);
		if (previousNode != null) {
			min = Math.min(min, Math.abs(node.val) - Math.abs(previousNode.val));
		}
		previousNode = node;
		dfsInOrderOptimzed(node.right);
	}

	public int getMinimumDifference_Optimized(TreeNode node) {

		dfsInOrderOptimzed(node);
		System.out.println(" Optimized : " + min);
		return min;
	}

	public static void main(String[] args) {

		TreeNode root = new TreeNode(50);

		TreeNode left11 = new TreeNode(25);

		TreeNode right12 = new TreeNode(65);

		root.left = left11;
		root.right = right12;

		TreeNode left21 = new TreeNode(20);

		TreeNode right22 = new TreeNode(30);

		TreeNode left23 = new TreeNode(55);

		TreeNode right24 = new TreeNode(69);

		left11.left = left21;
		left11.right = right22;
		right12.left = left23;
		right12.right = right24;

		MinAbsDiffBST main = new MinAbsDiffBST();
		main.getMinimumDifference_BF(root);
		System.out.println("-------------");
		main.getMinimumDifference_Optimized(root);

	}

}

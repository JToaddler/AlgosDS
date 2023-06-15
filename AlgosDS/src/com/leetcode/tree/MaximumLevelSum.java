package com.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

import com.leetcode.tree.MinAbsDiffBST.TreeNode;

/**
 * https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/
 * 
 * @author Anto
 *
 */
public class MaximumLevelSum {

	public int bfs(TreeNode root) {
		int level = 0;
		int previousSum = 0;
		Queue<TreeNode> queue = new LinkedList<>();

		queue.offer(root);

		while (!queue.isEmpty()) {
			level++;
			int currentSum = 0;
			for (int s = queue.size(); s > 0; s--) {
				TreeNode node = queue.poll();
				currentSum = currentSum + node.val;
				System.out.println(node.val);
				if (node.left != null)
					queue.add(node.left);
				if (node.right != null)
					queue.add(node.right);
				if (currentSum > previousSum) {
					previousSum = currentSum;
				}
			}
		}
		return level;
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
		MaximumLevelSum main = new MaximumLevelSum();
		main.bfs(root);
	}

}

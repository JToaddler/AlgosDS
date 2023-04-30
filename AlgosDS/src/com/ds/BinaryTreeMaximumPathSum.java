package com.ds;

import com.ds.Tree.TreeNode;

/**
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/
 * 
 * https://www.youtube.com/watch?v=6cA_NDtpyz8
 * 
 * @author Anto
 *
 */
public class BinaryTreeMaximumPathSum {

	private int maxPath = Integer.MIN_VALUE;

	public int maxPath(TreeNode node) {
		System.out.println("Max Sum Path :" + postTraversal(node));
		return maxPath;
	}

	public int postTraversal(TreeNode node) {
		if (node == null) {
			return 0;
		}
		int left = Math.max(postTraversal(node.left), 0);
		int right = Math.max(postTraversal(node.right), 0);
		maxPath = Math.max(maxPath, left + right + node.root);
		return Math.max(left, right) + node.root;
	}

	public static void main(String[] args) {
		Tree tree = new Tree();
		TreeNode rootNode = tree.new TreeNode(45);
		System.out.println("Root node =45");
		tree.insert(rootNode, 37);
		tree.insert(rootNode, 58);
		tree.insert(rootNode, 43);
		tree.insert(rootNode, 35);
		tree.insert(rootNode, 49);
		tree.insert(rootNode, 89);
		tree.insert(rootNode, -2);
		BinaryTreeMaximumPathSum cal = new BinaryTreeMaximumPathSum();
		cal.maxPath(rootNode);
	}

}

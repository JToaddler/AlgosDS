package com.ds;

public class Tree {

	class TreeNode {

		int root;
		TreeNode left;
		TreeNode right;

		public TreeNode(int value) {
			this.root = value;
		}

	}

	public void traverseDFS(TreeNode node) {

		if (node != null) {
			this.traverseDFS(node.left);
			System.out.print(node.root + " ");
			this.traverseDFS(node.right);
		}
	}

	public void insert(TreeNode node, int value) {
		if (node.root > value) { // add value to left side of the branch
			if (node.left == null) {
				TreeNode leftNode = new TreeNode(value);
				node.left = leftNode;
				System.out.println("Value " + value + "  added to the left of " + node.root);
			} else { // recursive call- left node already present
				insert(node.left, value);
			}
		}

		if (node.root < value) {// add value to Right side of the branch
			if (node.right == null) {
				TreeNode rightNode = new TreeNode(value);
				node.right = rightNode;
				System.out.println("Value " + value + "  added to the Right of " + node.root);
			} else { // recursive call- left node already present
				insert(node.right, value);
			} 
		}
		if (node.root == value) {
			System.out.println("Value already exist :" + value);
		}

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
		tree.traverseDFS(rootNode);
	}

}

package com.ds.tree;

public class BST {

	private Node root;

	public void insert(int data) {
		if (root == null) {
			root = new Node(data);
			return;
		}
		insertNode(root, data);
		System.out.println("Inserted Node  : " + data);
	}

	public void insertNode(Node node, int data) {
		Node temp = null;
		if (node.val >= data) {
			if (node.left == null)
				node.left = new Node(data);
			else
				temp = node.left;
		} else {
			if (node.right == null)
				node.right = new Node(data);
			else
				temp = node.right;
		}
		insertNode(temp, data);
	}

	public static void main(String[] args) {

		/**
		 * <code>
		 
		 				50
		 			  /    \
		 			45      55
		 		   /  \    /  \
		 		 37   48  51   68
		 		  			  /  \
		 		  			 62	  79
		
		
		 </code>
		 */

		BST bst = new BST();
		bst.insert(50);
	}

}

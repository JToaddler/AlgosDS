package com.ds.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BST {

	private Node root;

	public void insert(int data) {

		if (root == null) {
			root = new Node(data);
			return;
		} else
			insertNode(root, data);

	}

	private void levelOrderTraversal() {
		if (root == null)
			return;
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node last = queue.remove();
			if (last.left != null)
				queue.add(last.left);
			if (last.right != null)
				queue.add(last.right);
			System.out.print(last.val + " ");
		}
	}

	private Node insertNode(Node node, int data) {

		Node temp;
		if (node.val > data) {
			if (node.left == null) {
				node.left = new Node(data);
				return node.left;
			} else {
				temp = node.left;
			}
		} else {
			if (node.right == null) {
				node.right = new Node(data);
				return node.right;
			} else {
				temp = node.right;
			}
		}
		return insertNode(temp, data);
	}

	public void delete(int data) {

	}

	public Node deleteNode(Node node, int data) {

		if (node == null)
			return node;

		if (node.val > data)
			deleteNode(node.left, data);
		else if (node.val < data) {
			deleteNode(node.right, data);
		}

		if (node.left == null) {
			Node temp = node.right;
			return temp;
		} else if (node.right == null) {
			Node temp = node.left;
			return temp;
		}
		// both child exists
		else {

			// when both child exists, find the min in the right sub tree.

			Node succParent = node;

			// Find successor
			Node succ = node.right;

			while (succ.left != null) {
				succParent = succ;
				succ = succ.left;
			}
			if (succParent != node)
				succParent.left = succ.right;
			else
				succParent.right = succ.right;
			node.val = succ.val;
			return node;
		}

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
		bst.insert(45);
		bst.insert(55);
		bst.insert(37);
		bst.insert(48);
		bst.insert(51);
		bst.insert(68);
		bst.insert(62);
		bst.insert(79);
		bst.levelOrderTraversal();
	}

}

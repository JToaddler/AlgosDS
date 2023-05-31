package com.ds.tree.avl;

/**
 * 
 * https://www.youtube.com/watch?v=jDM6_TnYIqE
 * 
 * 
 * https://www.programiz.com/dsa/avl-tree
 * 
 * 
 * 
 * <code>
    Complexities of Different Operations on an AVL Tree
	Insertion	Deletion	Search
	O(log n)	O(log n)	O(log n)
	</code>
 * 
 * @author Anto
 *
 */
public class AVLTree {

	Node root;

	public int height(Node node) {
		return node == null ? -1 : node.height;
	}

	public int max(int n1, int n2) {
		return n1 > n2 ? n1 : n2;
	}

	public Node nodeWithMimumValue(Node node) {
		Node current = node;
		while (current.left != null) {
			current = current.left;
		}
		return current;
	}

	public int getBalanceFactor(Node node) {
		if (node == null)
			return 0;
		return height(node.left) - height(node.right);
	}

	public Node insertNode(Node node, int data) {
		if (node == null) {
			return new Node(data);
		}
		if (node.val > data) {
			node.left = insertNode(node.left, data);
		} else if (node.val < data) {
			node.right = insertNode(node.right, data);
		} else {
			System.out.println("Duplicate Key");
		}
		return rebalance(node, data);
	}

	private Node rebalance(Node node, int data) {
		updateHeight(node);
		int balancingFactor = getBalanceFactor(node);
		System.out.println("Node [ val = " + node.val + " height =" + node.height + " Balancing Factor ="
				+ balancingFactor + " ]");
		if (balancingFactor > 1) {
			if (data < node.left.val) {
				return rightRotate(node);
			} else if (data > node.left.val) {
				node.left = leftRotate(node.left);
				return rightRotate(node);
			}
		}
		if (balancingFactor < -1) {
			if (data > node.right.val) {
				return leftRotate(node);
			} else if (data < node.right.val) {
				node.right = rightRotate(node.right);
				return leftRotate(node);
			}
		}
		return node;
	}

	public Node leftRotate(Node x) {
		Node y = x.right;
		Node T2 = y.left;
		y.left = x;
		x.right = T2;
		x.height = max(height(x.left), height(x.right)) + 1;
		y.height = max(height(y.left), height(y.right)) + 1;
		return y;
	}

	public Node rightRotate(Node y) {
		Node x = y.left;
		Node T2 = x.right;
		x.right = y;
		y.left = T2;
		y.height = max(height(y.left), height(y.right)) + 1;
		x.height = max(height(x.left), height(x.right)) + 1;
		return x;
	}

	private void updateHeight(Node node) {
		node.height = 1 + max(height(node.left), height(node.right));
	}

	// Print the tree
	private void printTree(Node currPtr, String indent, boolean last) {
		if (currPtr != null) {
			System.out.print(indent);
			if (last) {
				System.out.print("R----");
				indent += "   ";
			} else {
				System.out.print("L----");
				indent += "|  ";
			}
			System.out.println(currPtr.val);
			printTree(currPtr.left, indent, false);
			printTree(currPtr.right, indent, true);
		}
	}

	public static void main(String[] args) {
		AVLTree tree = new AVLTree();
		tree.root = tree.insertNode(tree.root, 50);
		tree.root = tree.insertNode(tree.root, 55);
		tree.root = tree.insertNode(tree.root, 60);
		tree.root = tree.insertNode(tree.root, 65);
		tree.root = tree.insertNode(tree.root, 75);
		tree.root = tree.insertNode(tree.root, 80);
		System.out.println(tree);
		tree.printTree(tree.root, "", true);
	}

}

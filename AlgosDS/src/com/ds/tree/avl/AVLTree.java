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

	Node deleteNode(Node root, int item) {

		// Find the node to be deleted and remove it
		if (root == null)
			return root;
		if (item < root.val)
			root.left = deleteNode(root.left, item);
		else if (item > root.val)
			root.right = deleteNode(root.right, item);
		else {
			if ((root.left == null) || (root.right == null)) {
				Node temp = null;
				if (temp == root.left)
					temp = root.right;
				else
					temp = root.left;
				if (temp == null) {
					temp = root;
					root = null;
				} else
					root = temp;
			} else {
				Node temp = nodeWithMimumValue(root.right);
				root.val = temp.val;
				root.right = deleteNode(root.right, temp.val);
			}
		}
		if (root == null)
			return root;

		// Update the balance factor of each node and balance the tree
		root.height = max(height(root.left), height(root.right)) + 1;
		int balanceFactor = getBalanceFactor(root);
		if (balanceFactor > 1) {
			if (getBalanceFactor(root.left) >= 0) {
				return rightRotate(root);
			} else {
				root.left = leftRotate(root.left);
				return rightRotate(root);
			}
		}
		if (balanceFactor < -1) {
			if (getBalanceFactor(root.right) <= 0) {
				return leftRotate(root);
			} else {
				root.right = rightRotate(root.right);
				return leftRotate(root);
			}
		}
		return root;
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
		tree.root = tree.insertNode(tree.root, 33);
		tree.root = tree.insertNode(tree.root, 13);
		tree.root = tree.insertNode(tree.root, 53);
		tree.root = tree.insertNode(tree.root, 9);
		tree.root = tree.insertNode(tree.root, 21);
		tree.root = tree.insertNode(tree.root, 61);
		tree.root = tree.insertNode(tree.root, 8);
		tree.root = tree.insertNode(tree.root, 11);
		tree.printTree(tree.root, "", true);
		tree.root = tree.deleteNode(tree.root, 13);
		System.out.println("After Deletion: ");
		tree.printTree(tree.root, "", true);
	}

}

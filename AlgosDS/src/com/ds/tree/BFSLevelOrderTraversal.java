package com.ds.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * https://www.java2novice.com/java-interview-programs/level-order-traversal-binary-search-tree-bst/
 * 
 * 
 * Since each node is visited at least once, the time complexity is O(n).
 * 
 * The space complexity is also O(n) since the queue can contain all the leaf
 * nodes in the worst case.
 * 
 * 
 * @author Anto
 *
 */
public class BFSLevelOrderTraversal {

	public static void main(String[] args) {
		Node tree = createTree();
		levelOrderTraversal(tree);
	}

	public static void levelOrderTraversal(Node node) {

		if (node == null)
			return;

		Queue<Node> queue = new LinkedList<Node>();

		queue.add(node);

		while (!queue.isEmpty()) {
			Node removed = queue.remove();
			if (removed.left != null)
				queue.add(removed.left);
			if (removed.right != null)
				queue.add(removed.right);

			System.out.print(removed.val + " ");
		}

	}

	public static Node createTree() {

		/**
		 * <code>
		 
		 				50
		 			  /    \
		 			45      55
		 		   /  \    /  \
		 		 37   48  51   68
		 		  			  /  \
		 		  			 62	  79
		
			[37, 45, 48, 50, 51, 55, 62, 68, 79]
		
		 </code>
		 */

		Node root = new Node(50);

		Node h1Left = new Node(45);
		Node h1Right = new Node(55);

		root.left = h1Left;
		root.right = h1Right;

		Node h2N1Left = new Node(37);
		Node h2N2Right = new Node(48);

		h1Left.left = h2N1Left;
		h1Left.right = h2N2Right;

		Node h2N3Left = new Node(51);
		Node h2N4Right = new Node(68);

		h1Right.left = h2N3Left;
		h1Right.right = h2N4Right;

		h2N4Right.left = new Node(62);
		h2N4Right.right = new Node(79);

		return root;
	}
}

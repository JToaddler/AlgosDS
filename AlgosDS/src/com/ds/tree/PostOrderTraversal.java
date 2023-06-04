package com.ds.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Left Child -> Right Child -> Current Node
 * 
 * The following steps are used to perform the postorder traversal:
 * 
 * Traverse the left subtree by calling the postorder function recursively.
 * Traverse the right subtree by calling the postorder function recursively.
 * Access the data part of the current node.
 * 
 * The time complexity of postorder traversal is O(n), where 'n' is the size of
 * binary tree.
 * 
 * Whereas, the space complexity of postorder traversal is O(1), if we do not
 * consider the stack size for function calls. Otherwise, the space complexity
 * of postorder traversal is O(h), where 'h' is the height of tree.
 * 
 * https://www.javatpoint.com/postorder-traversal
 * 
 * @author Anto
 *
 */
public class PostOrderTraversal {

	static List<Integer> list = new ArrayList<Integer>();

	public static void postOrderTraversal(Node node) {

		if (node == null)
			return;

		postOrderTraversal(node.left);
		postOrderTraversal(node.right);
		System.out.println(node.val);
		list.add(node.val);
	}

	public static void main(String[] args) {
		Node tree = createTree();
		postOrderTraversal(tree);
		System.out.println(list);
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
		[37, 48, 45, 51, 62, 79, 68, 55, 50]
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

package com.ds.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Before visiting any child nodes, read the value of the current node.
 * 
 * Current Node -> Left Child -> Right Child
 * 
 * The time complexity of preorder traversal is O(n), where 'n' is the size of
 * binary tree.
 * 
 * Whereas, the space complexity of preorder traversal is O(1), if we do not
 * consider the stack size for function calls. Otherwise, the space complexity
 * of pre-order traversal is O(h), where 'h' is the height of the tree.
 * 
 * https://www.javatpoint.com/preorder-traversal
 * 
 * @author Anto
 *
 */
public class PreOrderTraversal {

	static List<Integer> list = new ArrayList<Integer>();

	public static void preOrderTraversalPrint(Node node) {

		if (node == null)
			return;
		System.out.println(node.val);
		preOrderTraversalPrint(node.left);
		preOrderTraversalPrint(node.right);

	}

	public static void preOrderTraversal(Node node) {
		if (node == null)
			return;
		list.add(node.val);
		preOrderTraversal(node.left);
		preOrderTraversal(node.right);
	}

	public static String preOrderTraversal2(Node node) {

		if (node == null)
			return "";
		String str = " " + node.val;
		String strL = str + " " + preOrderTraversal2(node.left);
		String strR = strL +  preOrderTraversal2(node.right);
		return strR;
	}

	public static void main(String[] args) {

		Node tree = createTree();
		preOrderTraversalPrint(tree);
		preOrderTraversal(tree);
		System.out.println(list);
		String str = preOrderTraversal2(tree);
		System.out.println(str);
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
		[50, 45, 37, 48, 55, 51, 68, 62, 79]
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

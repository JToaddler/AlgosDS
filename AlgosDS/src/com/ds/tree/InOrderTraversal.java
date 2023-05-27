package com.ds.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * The time complexity of Inorder traversal is O(n), where 'n' is the size of
 * binary tree.
 * 
 * Whereas, the space complexity of inorder traversal is O(1), if we do not
 * consider the stack size for function calls. Otherwise, the space complexity
 * of inorder traversal is , O(h) , where 'h' is the height of tree.
 * 
 * Left Child -> Current Node -> Right Child
 * 
 * https://www.javatpoint.com/inorder-traversal
 * 
 * @author Anto
 *
 */
public class InOrderTraversal {

	static List<Integer> list = new ArrayList<Integer>();

	public static void inOrderTraversalPrint(Node node) {

		if (node == null)
			return;

		inOrderTraversalPrint(node.left);
		System.out.print(node.val + " ");
		System.out.println();
		inOrderTraversalPrint(node.right);
	}

	public static void inOrderTraversal(Node node) {

		if (node == null)
			return;

		inOrderTraversal(node.left);
		list.add(node.val);
		inOrderTraversal(node.right);
	}

	public static String inOrderTraversal2(Node node) {

		if (node == null)
			return "";
		else {

			String strl = inOrderTraversal2(node.left);
			String str = " " + node.val + " ";
			String strR = inOrderTraversal2(node.right);
			return strl + str + strR;
		}
	}

	public static void main(String[] args) {
		Node root = createTree();
		inOrderTraversalPrint(root);
		inOrderTraversal(root);
		System.out.println(list);
		String result = inOrderTraversal2(root);
		System.out.println(result);
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

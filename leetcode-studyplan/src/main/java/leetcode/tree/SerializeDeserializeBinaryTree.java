package leetcode.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import leetcode.model.TreeNode;

/**
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 * 
 */
public class SerializeDeserializeBinaryTree {

	public static TreeNode deSerialize(List<String> list) {

		if (list.get(0).equals("null")) {
			list.remove(0);
			return null;
		}
		TreeNode root = new TreeNode(Integer.valueOf(list.get(0)));
		list.remove(0);
		root.left = deSerialize(list);
		root.right = deSerialize(list);
		return root;
	}

	// Decodes your encoded data to tree.
	public static TreeNode deserialize(String data) {
		String[] array = data.split(",");
		List<String> list = new LinkedList<>(Arrays.asList(array));
		TreeNode root = deSerialize(list);
		return root;
	}

	// Encodes a tree to a single string.
	public static String serialize(TreeNode root) {
		StringBuilder sb = new StringBuilder();

		serialize(root, sb);

		return sb.toString();
	}

	public static void serialize(TreeNode root, StringBuilder sb) {
		if (root == null) {
			sb.append("null,");
		} else {
			sb.append(root.val).append(",");
			serialize(root.left, sb);
			serialize(root.right, sb);
		}
	}

	public static void main(String[] args) {

		/**
		 * <code>
		 * 				  9
		 * 			   /    \
		 * 			 11      65
		 * 			/ \     /  \
		 * 		   7	5  22   3
		 * </code>
		 */

		TreeNode root = new TreeNode(9);

		TreeNode left_l1 = new TreeNode(11);
		TreeNode right_l1 = new TreeNode(65);

		TreeNode left_l2_1 = new TreeNode(7);
		TreeNode right_l2_2 = new TreeNode(5);
		TreeNode left_l2_3 = new TreeNode(22);
		TreeNode right_l2_4 = new TreeNode(3);

		root.left = left_l1;
		root.right = right_l1;

		left_l1.left = left_l2_1;
		left_l1.right = right_l2_2;

		right_l1.left = left_l2_3;
		right_l1.right = right_l2_4;

		String str = serialize(root);
		System.out.print(str);
		deserialize(str);
	}

}

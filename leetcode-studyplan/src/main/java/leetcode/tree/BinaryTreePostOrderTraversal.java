package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

import leetcode.model.TreeNode;

/**
 * https://leetcode.com/problems/binary-tree-postorder-traversal/
 * 
 * 
 * 
 */
public class BinaryTreePostOrderTraversal {

	public static void main(String[] args) {
		
	}
	
	

	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null)
			return res;
		dfsPostOrder(root, res);
		return res;
	}

	public void dfsPostOrder(TreeNode node, List<Integer> res) {
		if (node == null)
			return;
		dfsPostOrder(node.left, res);
		dfsPostOrder(node.right, res);
		res.add(node.val);
	}

}

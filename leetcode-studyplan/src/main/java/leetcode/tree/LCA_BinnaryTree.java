package leetcode.tree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import leetcode.model.TreeNode;

/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree
 * 
 */
public class LCA_BinnaryTree {

	/**
	 * Time Complexity : O(N), where N is the number of nodes in the binary tree. In
	 * the worst case we might be visiting all the nodes of the binary tree.
	 * 
	 * Space Complexity : O(N). In the worst case space utilized by the stack, the
	 * parent pointer dictionary and the ancestor set, would be N each, since the
	 * height of a skewed binary tree could be N.
	 */
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		Map<TreeNode, TreeNode> map = new HashMap<>();
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		map.put(root, null);
		while (!map.containsKey(p) || !map.containsKey(q)) {
			TreeNode node = stack.pop();
			if (node.left != null) {
				stack.add(node.left);
				map.put(node.left, node);
			}
			if (node.right != null) {
				stack.add(node.right);
				map.put(node.right, node);
			}
		}
		Set<TreeNode> set = new HashSet<>();
		while (p != null) {
			set.add(p);
			p = map.get(p);
		}
		while (!set.contains(q)) {
			q = map.get(q);
		}
		return q;
	}

}

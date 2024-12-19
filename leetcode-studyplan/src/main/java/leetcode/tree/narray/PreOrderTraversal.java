package leetcode.tree.narray;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * https://leetcode.com/problems/n-ary-tree-preorder-traversal
 * 
 */
public class PreOrderTraversal {

	/**
	 * Complexity Analysis
	 * 
	 * Time complexity: we visit each node exactly once, and for each visit, the
	 * complexity of the operation (i.e. appending the child nodes) is proportional
	 * to the number of child nodes n (n-ary tree). Therefore the overall time
	 * complexity is O(N), where N is the number of nodes, i.e. the size of the
	 * tree.
	 * 
	 * Space complexity: depending on the tree structure, we could keep up to the
	 * entire tree, therefore, the space complexity is O(N).
	 * 
	 * @param root
	 * @return
	 */
	public List<Integer> preorde_Iteration(Node root) {
		List<Integer> res = new ArrayList<>();
		if (root == null)
			return res;
		Deque<Node> stack = new ArrayDeque<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			Node removed = stack.pop();
			res.add(removed.val);
			if (removed.children != null)
				for (int i = removed.children.size() - 1; i >= 0; i--) {
					Node child = removed.children.get(i);
					if (child != null)
						stack.push(child);
				}
		}
		return res;
	}

	public List<Integer> preorder_recursion(Node root) {
		List<Integer> res = new ArrayList<>();
		preOrder(root, res);
		return res;
	}

	public void preOrder(Node node, List<Integer> res) {
		if (node == null)
			return;
		res.add(node.val);
		for (Node child : node.children)
			preOrder(child, res);
	}
}

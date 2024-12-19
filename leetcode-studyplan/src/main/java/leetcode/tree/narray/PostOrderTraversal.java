package leetcode.tree.narray;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

/**
 * https://leetcode.com/problems/n-ary-tree-postorder-traversal
 * 
 */
public class PostOrderTraversal {

	/**
	 * Time complexity: O(m)
	 * 
	 * The main loop iterates over every node in the tree, taking O(m) time. Each
	 * stack operation inside the loop takes constant time. Reversing the result
	 * list takes an additional linear time.
	 * 
	 * Thus, the overall time complexity of the algorithm is O(m).
	 * 
	 * Space complexity: O(m)
	 * 
	 * In the worst case, if the tree is highly unbalanced (e.g., a skewed tree),
	 * the stack can grow to store all nodes at once, contributing O(m) to the space
	 * complexity. No other additional data structures are used.
	 * 
	 * Thus, the space complexity of the algorithm is O(m).
	 * 
	 * @param root
	 * @return
	 */
	public List<Integer> postorder(Node root) {
		List<Integer> res = new ArrayList<>();
		if (root == null)
			return res;
		Deque<Node> stack = new ArrayDeque<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			Node removed = stack.pop();
			res.add(removed.val);
			if (removed.children != null)
				for (Node child : removed.children) {
					stack.push(child);
				}
		}
		Collections.reverse(res);
		return res;
	}

	/**
	 * Let m be the number of nodes in the tree.
	 * 
	 * Time complexity: O(m)
	 * 
	 * The method traversePostorder visits each node in the tree exactly once. Thus,
	 * the time complexity of the algorithm is O(m).
	 * 
	 * Space complexity: O(m)
	 * 
	 * The traversePostorder method uses recursion, and the maximum depth of the
	 * recursion is the height of the tree, which is O(m) in the worst case (for a
	 * skewed tree).
	 * 
	 * Thus, the space complexity of the algorithm is also O(m).
	 * 
	 * 
	 */
	public List<Integer> postorder_recursion(Node root) {
		List<Integer> list = new ArrayList<>();
		dfsPostOrder(root, list);
		return list;
	}

	public void dfsPostOrder(Node node, List<Integer> list) {
		if (node == null)
			return;
		if (node.children != null)
			for (Node child : node.children) {
				dfsPostOrder(child, list);
			}
		list.add(node.val);
	}

}

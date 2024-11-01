package leetcode.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CloneGraph {

	static Map<Node, Node> visited_DFS = new HashMap<>();

	public static void main(String[] args) {

	}

	public static Node cloneGraph_DFS(Node node) {
		if (node == null)
			return node;
		if (visited_DFS.containsKey(node)) {
			return visited_DFS.get(node);
		}
		Node clone = new Node(node.val, new ArrayList<>());
		visited_DFS.put(node, clone);
		for (Node neighbor : node.neighbors) {
			clone.neighbors.add(cloneGraph_DFS(neighbor));
		}
		return clone;
	}

	public Node cloneGraph_BFS(Node node) {
		if (node == null) {
			return node;
		}
		Map<Node, Node> visited = new HashMap<>();
		Queue<Node> que = new LinkedList<>();
		que.add(node);
		visited.put(node, new Node(node.val, new ArrayList<Node>()));
		while (!que.isEmpty()) {
			Node n = que.poll();
			for (Node neighbor : n.neighbors) {
				if (!visited.containsKey(neighbor)) {
					visited.put(neighbor, new Node(neighbor.val, new ArrayList<Node>()));
					que.add(neighbor);
				}
				visited.get(n).neighbors.add(visited.get(neighbor));
			}
		}
		return visited.get(node);
	}

}

class Node {
	public int val;
	public List<Node> neighbors;

	public Node() {
		val = 0;
		neighbors = new ArrayList<Node>();
	}

	public Node(int _val) {
		val = _val;
		neighbors = new ArrayList<Node>();
	}

	public Node(int _val, ArrayList<Node> _neighbors) {
		val = _val;
		neighbors = _neighbors;
	}
}
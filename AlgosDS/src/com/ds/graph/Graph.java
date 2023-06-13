package com.ds.graph;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

/**
 * 
 * 
 * @author Anto
 *
 * @param <T>
 */
public class Graph {

	HashMap<Vertex, List<Vertex>> adjVertices;

	Graph() {
		adjVertices = new HashMap<>();
	}

	class Vertex {
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getEnclosingInstance().hashCode();
			result = prime * result + Objects.hash(label);
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Vertex other = (Vertex) obj;
			if (!getEnclosingInstance().equals(other.getEnclosingInstance()))
				return false;
			return Objects.equals(label, other.label);
		}

		String label;

		Vertex(String label) {
			this.label = label;
		}

		@Override
		public String toString() {
			return " " + label + " ";
		}

		private Graph getEnclosingInstance() {
			return Graph.this;
		}
	}

	public void addVertex(String label) {
		adjVertices.putIfAbsent(new Vertex(label), new LinkedList<Vertex>());
	}

	public void addEdges(String label1, String label2) {
		Vertex v1 = new Vertex(label1);
		Vertex v2 = new Vertex(label2);
		// this is an undirected graph
		adjVertices.get(v1).add(v2);
		adjVertices.get(v2).add(v1);

	}

	public void removeEdge(String label1, String label2) {
		Vertex v1 = new Vertex(label1);
		Vertex v2 = new Vertex(label2);
		List<Vertex> v1List = adjVertices.get(v1);
		if (v1List != null)
			v1List.remove(v2);
		List<Vertex> v2List = adjVertices.get(v2);
		if (v2List != null)
			v2List.remove(v1);
	}

	public void removeVertex(String label) {
		Vertex v = new Vertex(label);

		// this removes the node
		adjVertices.remove(new Vertex(label));

		// this removes any edges connecting to the node
		// with the given label
		adjVertices.values().stream().forEach(item -> item.remove(v));
	}

	public List<Vertex> getAdjVertices(String label) {
		return adjVertices.getOrDefault(new Vertex(label), new LinkedList<Vertex>());
	}

	public Set<String> breadthFirstTraversal(Graph graph, String root) {
		Set<String> vistied = new LinkedHashSet<>();
		Queue<String> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			String lable = queue.poll();
			if (!vistied.contains(lable)) {
				vistied.add(lable);
				for (Vertex vertex : getAdjVertices(lable)) {
					queue.add(vertex.label);
				}
			}
		}
		System.out.println("BFS : Staring Vertex:" + root + ",Visted Order:" + vistied);
		return vistied;
	}

	public Set<String> depthFirstTraversal(Graph graph, String root) {
		Set<String> vistied = new LinkedHashSet<>();
		LinkedList<String> stack = new LinkedList<>();
		stack.addFirst(root);
		while (!stack.isEmpty()) {
			String lable = stack.removeFirst();
			if (!vistied.contains(lable)) {
				vistied.add(lable);
				for (Vertex vertex : this.getAdjVertices(lable)) {
					stack.addFirst(vertex.label);
				}
			}
		}
		System.out.println("BFS : Staring Vertex:" + root + ",Visted Order:" + vistied);
		return vistied;
	}

	public static void main(String[] args) {
		Graph graph = new Graph();
		graph.addVertex("IND");
		graph.addVertex("RSA");
		graph.addVertex("PAK");
		graph.addVertex("CHN");
		graph.addVertex("BNG");
		graph.addVertex("MEX");
		graph.addVertex("NPL");
		graph.addVertex("BTN");
		graph.addVertex("NKR");
		graph.addVertex("SKR");
		graph.addVertex("MNR");
		graph.addVertex("KAZ");
		graph.addVertex("SRK");
		graph.addVertex("AFG");

		graph.addEdges("IND", "CHN");
		graph.addEdges("IND", "PAK");
		graph.addEdges("IND", "BNG");
		graph.addEdges("IND", "NPL");
		graph.addEdges("IND", "BTN");
		graph.addEdges("IND", "MNR");
		graph.addEdges("IND", "SRK");

		graph.addEdges("CHN", "NPL");
		graph.addEdges("CHN", "BTN");
		graph.addEdges("CHN", "NKR");
		graph.addEdges("CHN", "RSA");
		graph.addEdges("CHN", "PAK");

		graph.addEdges("PAK", "AFG");

		graph.addEdges("RSA", "KAZ");
		graph.addEdges("RSA", "BTN");
		graph.addEdges("BNG", "CHN");

		graph.addEdges("NKR", "SKR");

		graph.depthFirstTraversal(graph, "USA");
		graph.depthFirstTraversal(graph, "AUS");

		graph.depthFirstTraversal(graph, "IND");
		graph.breadthFirstTraversal(graph, "IND");
	}

}

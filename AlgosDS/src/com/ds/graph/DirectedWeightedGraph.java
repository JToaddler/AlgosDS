package com.ds.graph;

import java.util.HashSet;
import java.util.LinkedList;

/*
 * 
 * Directed Weighted Graph Using Adjacency list 
 * 
 * Why Adjacency list  ?
 * 
 * Time Complexity of Adjacency matrix is  O(1) 
 * Space complexity of Adjacency matrix is  O(V²)
 * Adjacency matrix is suitable only for Better for dense graphs i.e., having a lot of edges
 * Iterates over all of the edges in O(V²) time
 * 
 * 
 * Time Complexity of Adjacency list is O(V)
 * Uses O(V+E) space (worst case)
 * Better for sparse graphs i.e., having less number of edges
 * 
 * 
 * @author Anto
 *
 */
public class DirectedWeightedGraph {

	static class Graph {

		HashSet<Vertex> nodes;

		public Graph() {
			nodes = new HashSet<>();
		}

		public boolean addEdge(Vertex v1, Vertex v2, int weight) {
			return v1.getEdgeList().add(new Edges(v2, weight));
		}

		public boolean addVertex(Vertex v) {
			return nodes.add(v);
		}

		public HashSet<Vertex> getNodes() {
			return nodes;
		}

		public void setNodes(HashSet<Vertex> nodes) {
			this.nodes = nodes;
		}

		/**
		 * print graph in adjacency list
		 */
		public void printGraph() {

			StringBuilder sb = new StringBuilder();
			for (Vertex node : nodes) {
				sb.append("Vertex [" + node.name + "] Connected to : [");
				node.edgeList.forEach(item -> sb.append(item.getDestVertex().name));
				sb.append("]\n");
			}
			System.out.println(sb.toString());
		}

	}

	static class Vertex {

		String name;
		LinkedList<Edges> edgeList;

		public Vertex(String name) {
			this.name = name;
			edgeList = new LinkedList<>();
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public LinkedList<Edges> getEdgeList() {
			return edgeList;
		}

		public void setEdgeList(LinkedList<Edges> edgeList) {
			this.edgeList = edgeList;
		}

	}

	static class Edges {

		public int getWeight() {
			return weight;
		}

		public void setWeight(int weight) {
			this.weight = weight;
		}

		public Vertex getDestVertex() {
			return destVertex;
		}

		public void setDestVertex(Vertex destVertex) {
			this.destVertex = destVertex;
		}

		int weight;
		Vertex destVertex;

		public Edges(Vertex vertex, int weigt) {
			this.weight = weigt;
			this.destVertex = vertex;
		}
	}

	public static void main(String[] args) {

		DirectedWeightedGraph impl = new DirectedWeightedGraph();
		Graph graph = new Graph();

		Vertex a = new Vertex("A");
		Vertex b = new Vertex("B");
		Vertex c = new Vertex("C");

		Vertex con = new Vertex("1");

		Vertex x = new Vertex("X");
		Vertex y = new Vertex("Y");
		Vertex z = new Vertex("Z");

		graph.addVertex(a);
		graph.addVertex(b);
		graph.addVertex(c);

		graph.addVertex(con);

		graph.addVertex(x);
		graph.addVertex(y);
		graph.addVertex(z);

		graph.addEdge(a, con, 0);
		graph.addEdge(b, con, 0);
		graph.addEdge(c, con, 0);

		graph.addEdge(con, x, 0);
		graph.addEdge(con, y, 0);
		graph.addEdge(con, z, 0);
		graph.printGraph();
	}

}

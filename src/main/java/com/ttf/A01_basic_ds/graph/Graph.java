package com.ttf.A01_basic_ds.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Graph {
    Map<Integer, Node> nodes;
    Set<Edge> edges;

    public Graph() {
        this.nodes = new HashMap<>();
        this.edges = new HashSet<>();
    }

    public Graph(Map<Integer, Node> nodes, Set<Edge> edges) {
        this.nodes = nodes;
        this.edges = edges;
    }

    public static Graph convert(int[][] matrix) {
        Graph graph = new Graph();
        for (int[] edge: matrix) {
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];

            Node fromNode = null;
            Node toNode = null;

            if (!graph.nodes.containsKey(from)) {
                fromNode = new Node(from);
                fromNode.out++;
                graph.nodes.put(from, fromNode);
            }
            if (!graph.nodes.containsKey(to)) {
                toNode = new Node(to);
                toNode.in++;
                graph.nodes.put(to, toNode);
            }
            Edge e = new Edge(weight, fromNode, toNode);
            graph.edges.add(e);
            fromNode.edges.add(e);
            fromNode.neighbors.add(toNode);
        }

        return graph;
    }
}

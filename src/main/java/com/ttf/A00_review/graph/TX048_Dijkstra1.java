package com.ttf.A00_review.graph;

import com.ttf.A01_basic_ds.graph.Edge;
import com.ttf.A01_basic_ds.graph.Node;

import java.util.*;

public class TX048_Dijkstra1 {

    public static Map<Node, Integer> dijkstra1(Node start) {
        Map<Node, Integer> result = new HashMap<>();
        result.put(start, 0);
        Set<Node> selected = new HashSet<>();
        selected.add(start);
        Node minNode = getMinNodeUnSelected(result, selected);
        while (minNode != null) {
            // check the edges of the minNode
            List<Edge> edges = minNode.edges;
            for (Edge edge : edges) {
                Node toNode = edge.to;
                result.put(toNode, Math.min(result.getOrDefault(toNode, Integer.MAX_VALUE), result.get(minNode) + edge.weight));
            }
            selected.add(minNode);
            minNode = getMinNodeUnSelected(result, selected);
        }
        return result;
    }

    private static Node getMinNodeUnSelected(Map<Node, Integer> result, Set<Node> selected) {
        int min = Integer.MAX_VALUE;
        Node minNode = null;
        for (Map.Entry<Node, Integer> entry : result.entrySet()) {
            if (!selected.contains(entry.getKey())) {
                if (entry.getValue() < min) {
                    min = entry.getValue();
                    minNode = entry.getKey();
                }
            }
        }
        return minNode;
    }
}

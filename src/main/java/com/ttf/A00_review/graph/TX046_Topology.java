package com.ttf.A00_review.graph;

import com.ttf.A01_basic_ds.graph.Graph;
import com.ttf.A01_basic_ds.graph.Node;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TX046_Topology {
    /**
     * BFS-based topology sort
     */
    public static List<Node> topologySort(Graph graph) {
        List<Node> result = new LinkedList<>();
        Queue<Node> zeroNodes = new LinkedList<>();
        for(Node node: graph.nodes.values()){
            if(node.in == 0){
                zeroNodes.add(node);
            }
        }
        while (!zeroNodes.isEmpty()){
            Node node = zeroNodes.poll();
            result.add(node);
            for(Node next: node.neighbors){
                next.in--;
                if(next.in == 0){
                    zeroNodes.add(next);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] meta = {
                {1, 2, 1},
                {1, 3, 3},
                {2, 4, 2},
                {2, 5, 1},
                {3, 6, 4},
                {3, 7, 6},
                {4, 8, 1},
                {5, 8, 3},
                {6, 7, 1}
        };

        Graph g = Graph.convert(meta);
        List<Node> topology = topologySort(g);
        for(Node node: topology){
            System.out.println(node.value);
        }
    }
}

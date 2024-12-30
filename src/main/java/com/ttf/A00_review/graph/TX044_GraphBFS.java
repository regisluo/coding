package com.ttf.A00_review.graph;

import com.ttf.A01_basic_ds.graph.Graph;
import com.ttf.A01_basic_ds.graph.Node;

import java.util.Queue;

public class TX044_GraphBFS {
    // bfs from a node
    // a queue is needed to store the nodes
    public void bfs(Node node) {
        Queue<Node> queue = new java.util.LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (cur.visited) {
                continue;
            }
            cur.visited = true;
            System.out.println(cur.value);
            for (Node neighbor: cur.neighbors) {
                if (!neighbor.visited) {
                    queue.add(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
        // construct a graph
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

        TX044_GraphBFS graphBFS = new TX044_GraphBFS();
        graphBFS.bfs(g.nodes.get(1));
    }
}

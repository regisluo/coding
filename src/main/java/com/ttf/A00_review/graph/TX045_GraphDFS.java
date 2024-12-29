package com.ttf.A00_review.graph;

import com.ttf.A01_basic_ds.graph.Graph;
import com.ttf.A01_basic_ds.graph.Node;

import java.util.Stack;

public class TX045_GraphDFS {
    public void dfs(Node node) {
        Stack<Node> stack = new Stack<>();
        stack.push(node);
        print(node);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            for (Node neighbor: cur.neighbors) {
                if (!neighbor.visited) {
                    stack.push(cur);
                    stack.push(neighbor);
                    print(neighbor);
                    break;
                }
            }
        }

    }

    private void print(Node node) {
        node.visited = true;
        System.out.println(node.val);
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

        TX045_GraphDFS graphDFS = new TX045_GraphDFS();
        graphDFS.dfs(g.nodes.get(1));
    }
}

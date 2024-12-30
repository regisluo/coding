package com.ttf.A00_review.graph;

import java.util.*;

public class TX047_TopOrderDFS_Lintcode {


    public List<GraphNode> topSort(List<GraphNode> nodes) {
        Map<GraphNode, Record> node2Depth = new HashMap<>();
        List<Record> records = new ArrayList<>();
        for(GraphNode node: nodes){
            records.add(mostDepth(node, node2Depth));
        }
        Collections.sort(records, new RecordComparator());
        List<GraphNode> result = new ArrayList<>();
        for(Record record: records){
            result.add(record.node);
        }
        return result;
    }

    // given Node and graph structure
    private static class GraphNode {
        int label;
        List<GraphNode> neighbors;
        GraphNode(int x) {
            label = x;
            neighbors = new ArrayList<>();
        }
    }

    private static class Graph {
        List<GraphNode> nodes;
        Graph(List<GraphNode> nodes) {
            this.nodes = nodes;
        }
    }

    /**
     * DFS-based topology sort
     * We will define a Record class to store the node and its depth
     */
    private class Record {
        GraphNode node;
        int depth;

        Record() {
            this.depth = 0;
        }

        Record(GraphNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    public class RecordComparator implements Comparator<Record> {
        @Override
        public int compare(Record r1, Record r2) {
            return r2.depth - r1.depth;
        }
    }

    // using recursion to do DFS and get the Record for each node
    // below method returns the Record of a given GraphNode
    public Record mostDepth(GraphNode node, Map<GraphNode, Record> node2Depth) {
        if (node2Depth.containsKey(node)) {
            return node2Depth.get(node);
        }
        int maxDepth = 0;
        for(GraphNode next: node.neighbors){
            maxDepth = Math.max(maxDepth, mostDepth(next, node2Depth).depth);
        }
        Record result = new Record(node, maxDepth + 1);
        return result;
    }


}

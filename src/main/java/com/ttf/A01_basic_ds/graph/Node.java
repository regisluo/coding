package com.ttf.A01_basic_ds.graph;

import java.util.ArrayList;
import java.util.List;

public class Node {
    public int val;
    public List<Node> neighbors;
    public int in;
    public int out;
    public List<Edge> edges;
    public boolean visited;

    public Node(int val) {
        this.val = val;
        this.in = 0;
        this.out = 0;
        this.neighbors = new ArrayList<>();
        this.edges = new ArrayList<>();
    }



}

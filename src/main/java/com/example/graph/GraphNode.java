package com.example.graph;

import java.util.ArrayList;
import java.util.List;

public class GraphNode {
    public int val;
    public List<GraphNode> neighbors;
    public GraphNode() {
        val = 0;
        neighbors = new ArrayList<>();
    }
    public GraphNode(int val) {
        this.val = val;
        this.neighbors = new ArrayList<GraphNode>();
    }
    public GraphNode(int val, ArrayList<GraphNode> neighbors) {
        this.val = val;
        this.neighbors = neighbors;
    }

//    @Override
//    public String toString() {
//        StringBuilder builder = new StringBuilder();
//
////        for (T v : this.neighbors) {
//            builder.append(this.val + ": ");
//            for (GraphNode w : this.neighbors) {
//                builder.append(w.toString() + " ");
//            }
//            builder.append("\n");
//        }
//
//        return (builder.toString());
//    }
}

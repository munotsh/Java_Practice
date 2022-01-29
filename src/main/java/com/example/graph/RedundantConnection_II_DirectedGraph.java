package com.example.graph;

public class RedundantConnection_II_DirectedGraph {
    public static void main(String[] args) {
        RedundantConnection_II_DirectedGraph redundantConnection = new RedundantConnection_II_DirectedGraph();
        // int[][] edges = {{1, 2}, {2, 3}, {2, 4}, {2, 5}, {2, 6},{3,6},{3,7}};
        // output : [1,5]
        // int[][] edges = {{1, 2}, {1, 3}, {2, 4}, {2, 5}, {3, 6},{3,7},{7,1}};
        // output : [7,1]
        int[][] edges = {{2, 3}, {3, 4}, {4, 5}, {5, 2}, {1, 2}};
        // output : [5,2]
        int[] result = redundantConnection.findRedundantDirectedConnection(edges);
        System.out.println("[" + result[0] + "," + result[1] + "]");
    }

    private int[] findRedundantDirectedConnection(int[][] edges) {
        int[] graph = new int[edges.length + 1];

        int ans1[] = null; //first edge
        int ans2[] = null; //current edge

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            if (graph[v] > 0) { //[2,3] -> [1,3] / [2,3]
                ans1 = new int[]{graph[v], v};
                ans2 = edge;
            }

            graph[v] = u;
        }

        int[] parent = new int[edges.length + 1];

        for (int[] edge : edges) {

            if (edge == ans2) continue;

            int u = edge[0];
            int v = edge[1];

            int pu = findParent(u, parent);
            int pv = findParent(v, parent);

            if (pu == pv) { // if cycle
                return ans1 == null ? edge : ans1;
            }

            parent[pv] = u; //union/collapse
        }

        return ans2;
    }

    int findParent(int v, int[] parent) {
        if (parent[v] == 0) {
            parent[v] = v;
        }

        if (parent[v] != v) {
            parent[v] = findParent(parent[v], parent);
        }

        return parent[v];
    }
}

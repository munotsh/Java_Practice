package com.example.graph;

public class RedundantConnection_UndirectedGraph {
    public static void main(String[] args) {
        RedundantConnection_UndirectedGraph redundantConnection = new RedundantConnection_UndirectedGraph();
         int[][] edges = {{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}};
        // output : [1,5]

//        int[][] edges = {{1, 2}, {1, 3}, {2, 3}};
        // output : [2,3]
        int[] result = redundantConnection.findRedundantConnection(edges);
        System.out.println("[" + result[0] + "," + result[1] + "]");
    }


    public int[] findRedundantConnection(int[][] edges) {
        int[] parent = new int[edges.length+1];
        int[] res = new int[1];
        for (int i = 0; i < parent.length; i++)
            parent[0] = 0;
        for (int[] edge : edges) {
            int p1 = findPath(edge[0], parent);
            int p2 = findPath(edge[1], parent);
            if (p1 == p2)
                res = edge;
            parent[p1] = p2;
        }
        return res;
    }

    private int findPath(int i, int[] parent) {
        if (i == parent[i])
            return i;
        return findPath(parent[i], parent);
    }


//    private void union(int i, int j) {
//        int iRoot = find(i);
//        int jRoot = find(j);
//        if (iRoot != jRoot) {
//            parent[jRoot] = iRoot;
//        }
//    }
//
//    public int find(int node) {
//        while (parent[node] != node) {
//            node = find(parent[node]);
//        }
//        return node;
//    }


}

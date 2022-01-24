package com.example.graph;

import java.util.*;

public class GraphValidTree {
    public static void main(String[] args) {
        GraphValidTree graphValidTree = new GraphValidTree();
        int n = 5;
        int[][] edges = {{0, 1}, {0, 2}, {0, 3}, {1, 4}};
        //out : true

        //int n = 5;
        //int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}};
        //out : false
        System.out.println(graphValidTree.validTree(n, edges));
    }

    public boolean validTree(int n, int[][] edges) {
        List<Set<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjList.add(new HashSet<>());
        }

        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];

        // Check if graph has cycle
        if (hasCycle(0, visited, adjList, -1)) {
            return false;
        }

        // Check if graph is connected
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }

    public boolean hasCycle(int node, boolean[] visited, List<Set<Integer>> adjList, int parent) {
        visited[node] = true;

        for (int nextNode : adjList.get(node)) {
            // (1) If nextNode is visited but it is not the parent of the curNode, then there is cycle
            // (2) If nextNode is not visited but we still find the cycle later on, return true;
            if ((visited[nextNode] && parent != nextNode) || (!visited[nextNode] && hasCycle(nextNode, visited, adjList, node))) {
                return true;
            }
        }
        return false;
    }


}

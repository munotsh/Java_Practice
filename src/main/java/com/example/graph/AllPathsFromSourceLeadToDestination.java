package com.example.graph;

import java.util.*;

public class AllPathsFromSourceLeadToDestination {
    public static void main(String[] args) {
        AllPathsFromSourceLeadToDestination allPathsFromSourceLeadToDestination = new AllPathsFromSourceLeadToDestination();
//        TC: O(n+e) and SC: O(n+e). e = edges.length
//        int n = 3;
//        int[][] edges = {{0, 1}, {0, 2}};
//        int source = 0;
//        int destination = 2;
//          output : false
        int n = 4;
        int[][] edges = {{0, 1}, {0, 2}, {1, 3}, {2, 3}};
        int source = 0;
        int destination = 3;
//        output : true
        System.out.println(allPathsFromSourceLeadToDestination.leadsToDestination(n, edges, source, destination));
    }

    private boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        Set<Integer>[] graph = new Set[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new HashSet<>();
        }
        int[] inDegrees = new int[n];
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            inDegrees[edge[1]]++;
        }
        LinkedList<Integer> que = new LinkedList<Integer>();
        que.add(source);
        while (!que.isEmpty()) {
            int cur = que.poll();
            if (graph[cur].size() == 0 && cur != destination) {
                return false;

            }
            for (int nei : graph[cur]) {
                if (inDegrees[nei] < 0) {
                    return false;
                }
                inDegrees[nei]--;
                que.add(nei);
            }
        }
        return true;
    }
}

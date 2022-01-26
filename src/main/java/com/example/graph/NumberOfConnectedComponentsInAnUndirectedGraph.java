package com.example.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberOfConnectedComponentsInAnUndirectedGraph {
    public static void main(String[] args) {
        NumberOfConnectedComponentsInAnUndirectedGraph connectedComponents = new NumberOfConnectedComponentsInAnUndirectedGraph();
//        int n = 5;
//        int[][] edges = {{0, 1}, {1, 2}, {3, 4}};
//        output : 2
        int n = 5;
        int[][] edges = {{0, 1}, {2, 3}, {3, 4}};
//        output : 2
        System.out.println(connectedComponents.countComponents(n, edges));
    }

    private int countComponents(int n, int[][] edges) {
//        if(n==0 || n==1) return 0;  //optional
//        if(n == 2) return 1;        //optional
        int[] ids = new int[n];
        for (int i = 0; i < n; i++) {
            ids[i] = i;
        }
        for (int[] e : edges) {
            union(e[0],e[1],ids);
        }
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<ids.length;i++)
            set.add(find(i,ids));

        return set.size();
    }

    private void union(int edge1, int edge2, int[] ids) {
        int parent1 = find(edge1, ids);
        int parent2 = find(edge2, ids);
        ids[parent1] = parent2;
    }

    private int find(int edge, int[] ids) {
        if (ids[edge] != edge)
            ids[edge] = find(ids[edge], ids);
        return ids[edge];
    }
}

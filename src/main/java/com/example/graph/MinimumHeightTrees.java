package com.example.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MinimumHeightTrees {
    public static void main(String[] args) {
        MinimumHeightTrees minimumHeightTrees = new MinimumHeightTrees();
        int n = 4;
        int[][] edges = {{1, 0}, {1, 2}, {1, 3}};
//      output : [1]
//        int n = 6;
//        int[][] edges = {{3,0},{3,1},{3,2},{3,4},{5,4}};
//        output : [3, 4]
        System.out.println(minimumHeightTrees.findMinHeightTrees(n, edges));
    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        if (n == 0) return res;
        if (n == 1) {
            res.add(0);
            return res;
        }
        int[] inDegree = new int[n];
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            inDegree[e[0]]++;
            inDegree[e[1]]++;
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 1) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            res.clear();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int val = queue.poll();
                res.add(val);
                for (int connectedToVal : adj.get(val)) {
                    inDegree[connectedToVal]--;
                    if (inDegree[connectedToVal] == 1)
                        queue.add(connectedToVal);
                }
            }

        }
        return res;
    }
}

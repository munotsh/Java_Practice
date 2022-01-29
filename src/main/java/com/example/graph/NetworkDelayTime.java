package com.example.graph;

import java.util.*;
//Solution: DFS looking for longest time among shortest path to each node from K
//Based on the requirement of the question, we are actually looking for the maximum time among all the minimum times from K to each of the other nodes. Based on the abbstraction, we can get the following solution:
//
//First compute the shortest path from K to each of the other nodes.
//In this process we have to check each possible path exhaustively since there could be paths from K to V, say, K->V and K->U->V where K->u->V is shorter than K->V. And thus during the computing process we should check every possibilities and only store the shortest one.
//From all the shortest path from K to other nodes, return the max one which is the last node that receives the signal sent from K. Were there be a node whose shortest path is Integer.MAX_VALUE, indicating the node is not connected with K, we should return -1 as it is impossible for all nodes to get the signal.
//In order to make the algorithm runs quicker and make sure it ends even there is a loop in the graph, we sort the adjacency list of the graph and start computing greedily from short edge to long edge, so that we always get the shortest path first, if possible.
//
//Time complexity: O(N^N + N*NlogN) in the worst case. Since we can possibly visit each node up to N-1 times and use NlogN time to sort each column of the adjacency list.
//
//Space complexity: O(N + E). O(E) for the graph and O(N) for the recursion stack.

//int[][] times = {{1,2,1}};
//int n = 2;
//int source = 1;
//output : 1

//int[][] times = {{1,2,1}};
//int n = 2;
//int source = 2;
//output : -1
public class NetworkDelayTime {
    public static void main(String[] args) {
        NetworkDelayTime networkDelay = new NetworkDelayTime();
        int[][] times = {{2,1,1},{2,3,1},{3,4,1}};
        int n = 4;
        int source = 2;
//        output : 2

        System.out.println(networkDelay.networkDelayTime(times,n,source));
    }
    public int networkDelayTime(int[][] times, int n, int source) {

//        if(n == 2) return times[0][2];
        Map<Integer, List<int[]>> adjList = new HashMap<>();
        for (int[] time : times) {
            adjList.putIfAbsent(time[0],new ArrayList<int[]>());
            adjList.get(time[0]).add(new int[]{time[1], time[2]});
        }

        for (int node : adjList.keySet()) {
            Collections.sort(adjList.get(node), (a, b) -> {
                return a[1] - b[1];
            });
        }

        Map<Integer, Integer> dist = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            dist.put(i, Integer.MAX_VALUE);
        }
        dfs(adjList, dist, source, 0);

        int ret = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            if (dist.get(i) == Integer.MAX_VALUE) return -1;
            ret = Math.max(ret, dist.get(i));
        }

        return ret;
    }
    private void dfs(Map<Integer, List<int[]>> adjList, Map<Integer, Integer> dist, int start, int elapsed) {
        if (elapsed >= dist.get(start)) return;
        dist.put(start, elapsed);
        if (adjList.containsKey(start)) {
            for (int[] next : adjList.get(start)) {
                dfs(adjList, dist, next[0], elapsed + next[1]);
            }
        }
    }
}

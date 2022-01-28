package com.example.graph;

import java.util.LinkedList;
import java.util.Queue;

public class FriendCircles {
    public static void main(String[] args) {
        //TC:O(N) ans SC: O(row) row = number of row
        FriendCircles numberOfFriendCircles = new FriendCircles();
        int[][] friendMatrix = {{0,1,0,0,0},{1,0,1,0,0},{0,1,0,0,0},{0,0,0,0,1},{0,0,0,1,0}};
        System.out.println(numberOfFriendCircles.findFriendCircleNum(friendMatrix));
    }
    public int findFriendCircleNum(int[][] friendsGroup) {
        int ans  = 0;
        int v = friendsGroup.length;
        boolean visited[] = new boolean[v];
        for(int i =0; i<v; i++) {
            if(visited[i] == false){
                ans++;
                BFSHelper(friendsGroup, i, visited);
            }
        }
        return ans;
    }
    public static void BFSHelper(int adj_mat[][],int sv, boolean visited[]) {
        Queue<Integer> q = new LinkedList<>();
        q.add(sv);
        visited[sv] = true;
        int v = adj_mat.length;
        while(!q.isEmpty()) {
            int front = q.poll();
            for(int i =0; i <v; i++) {
                if(adj_mat[front][i] == 1 && visited[i] == false) {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }

//    public static int BFS(int ans, int adj_mat[][]) {
//        int v = adj_mat.length;
//        boolean visited[] = new boolean[v];
//        for(int i =0; i<v; i++) {
//            if(visited[i] == false){
//                ans++;
//                BFSHelper(adj_mat, i, visited);
//            }
//        }
//
//        return ans;
//    }
}

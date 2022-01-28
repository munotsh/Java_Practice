package com.example.graph;

public class NumberOfProvinces {
    public static void main(String[] args) {
        NumberOfProvinces numberOfProvinces = new NumberOfProvinces();
        //TC:O(N) ans SC: O(row) row = number of row
        //int[][] provinceMatrix = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        //output : 2
        int[][] provinceMatrix = {{1,0,0},{0,1,0},{0,0,1}};
        //output : 3
        System.out.println(numberOfProvinces.findCircleNum(provinceMatrix));
    }

    public int findCircleNum(int[][] isConnected) {
        int[] visited = new int[isConnected.length];
        int province = 0;
        for (int i = 0; i < isConnected.length; i++) {
            if(visited[i] == 0) {
                helper(i, isConnected, visited);
                province++;
            }
        }
        return province;
    }

    private void helper(int i, int[][] isConnected, int[] visited) {
        for (int j = 0; j < isConnected.length; j++) {
            if (isConnected[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                helper(j, isConnected, visited);
            }
        }
    }
}

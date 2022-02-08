package com.example.matrix;

import java.util.*;

public class RankTransformOfMatrix {
    public static void main(String[] args) {
        RankTransformOfMatrix rankTransformOfMatrix = new RankTransformOfMatrix();
        int[][] matrix = {{20, -21, 14}, {-19, 4, 19}, {22, -47, 24}, {-19, 4, 19}};
        //output : [[4, 2, 3], [1, 3, 4], [5, 1, 6], [1, 3, 4]]
        System.out.println(Arrays.deepToString(rankTransformOfMatrix.matrixRankTransform(matrix)));
    }

    public int[][] matrixRankTransform(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return new int[0][0];
        int row = matrix.length;
        int col = matrix[0].length;
        TreeMap<Integer, List<int[]>> treeMap = new TreeMap<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                List<int[]> list = treeMap.getOrDefault(matrix[i][j], new ArrayList<>());
                list.add(new int[]{i, j});
                treeMap.put(matrix[i][j], list);
            }
        }

        int[] minX = new int[row];
        int[] minY = new int[col];
        int[][] rankMatrix = new int[row][col];

        for (Map.Entry<Integer, List<int[]>> sameValueEntry : treeMap.entrySet()) {
            ArrayList<int[]> sameValueGroup = new ArrayList<>(sameValueEntry.getValue());

            //Create union and find data structure
            int[] parent = new int[sameValueGroup.size()];
            for (int i = 0; i < parent.length; i++) parent[i] = i;

            //sameValueGroup values should be grouped by same column and same row
            HashMap<Integer, List<Integer>> xMap = new HashMap<>();
            HashMap<Integer, List<Integer>> yMap = new HashMap<>();
            for (int i = 0; i < sameValueGroup.size(); i++) {
                int[] point = sameValueGroup.get(i);
                List<Integer> xList = xMap.getOrDefault(point[0], new ArrayList<>());
                List<Integer> yList = yMap.getOrDefault(point[1], new ArrayList<>());

                xList.add(i);
                yList.add(i);
                xMap.put(point[0], xList);
                yMap.put(point[1], yList);
            }
            for (Map.Entry<Integer, List<Integer>> xEntrySet : xMap.entrySet()) {
                List<Integer> xList = xEntrySet.getValue();
                for (int i = 1; i < xList.size(); i++) {
                    union(xList.get(i - 1), xList.get(i), parent);
                }
            }

            for (Map.Entry<Integer, List<Integer>> yEntrySet : yMap.entrySet()) {
                List<Integer> yList = yEntrySet.getValue();
                for (int i = 1; i < yList.size(); i++) {
                    union(yList.get(i - 1), yList.get(i), parent);
                }
            }
            HashMap<Integer, List<int[]>> sameRowColGroup = new HashMap<>();
            for (int i = 0; i < parent.length; i++) {
                int group = find(i, parent);
                List<int[]> list = sameRowColGroup.getOrDefault(group, new ArrayList<>());
                list.add(sameValueGroup.get(i));
                sameRowColGroup.put(group, list);
            }
            for (Map.Entry<Integer, List<int[]>> sameRowColEntry : sameRowColGroup.entrySet()) {
                int rank = 0;
                List<int[]> sameRowColValue = sameRowColEntry.getValue();

                for (int[] point : sameRowColValue) {
                    rank = Math.max(rank, minX[point[0]]);
                    rank = Math.max(rank, minY[point[1]]);
                }

                for (int[] point : sameRowColValue) {
                    rankMatrix[point[0]][point[1]] = rank + 1;
                    minX[point[0]] = rank + 1;
                    minY[point[1]] = rank + 1;
                }
            }
        }
        return rankMatrix;
    }

    private int find(int x, int parent[]) {
        if (parent[x] == x)
            return x;
        else {
            parent[x] = find(parent[x], parent);
            return parent[x];
        }
    }

    private void union(int x, int y, int parent[]) {
        int xparent = find(x, parent);
        int yparent = find(y, parent);
        parent[yparent] = xparent;
    }
}

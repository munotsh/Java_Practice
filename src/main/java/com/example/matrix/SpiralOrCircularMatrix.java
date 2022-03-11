package com.example.matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrCircularMatrix {
    public static void main(String[] args) {
        SpiralOrCircularMatrix spiralOrCircularMatrix = new SpiralOrCircularMatrix();
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        //OP:[1, 2, 3, 6, 9, 8, 7, 4, 5]
        System.out.println(spiralOrCircularMatrix.spiralOrder(matrix));
    }
    public List spiralOrder(int[][] matrix) {
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int n = matrix.length;
        int m = matrix[0].length;
        int d = 0;
        int row = 0;
        int col = 0;
        boolean[][] visited = new boolean[n][m];
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n * m; i++) {
            result.add(matrix[row][col]);
            visited[row][col] = true;
            row += dir[d][0];       // move forward
            col += dir[d][1];
            if (row < 0 || col < 0 || row >= n || col >= m || visited[row][col]) {
                row -= dir[d][0];   // revert last step
                col -= dir[d][1];
                d = (d + 1) % 4;    // change dir spirally
                row += dir[d][0];   // move forward by one step
                col += dir[d][1];
            }
        }
        return result;
    }
}

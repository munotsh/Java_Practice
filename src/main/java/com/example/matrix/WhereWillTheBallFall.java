package com.example.matrix;

import java.util.Arrays;

public class WhereWillTheBallFall {
    public static void main(String[] args) {
        WhereWillTheBallFall whereWillTheBallFall = new WhereWillTheBallFall();
        // tc -> m*n, sc-> m*n
        int[][] grid = {{1, 1, 1, -1, -1}, {1, 1, 1, -1, -1}, {-1, -1, -1, 1, 1}, {1, 1, 1, 1, -1}, {-1, -1, -1, -1, -1}};
        // output : 1-1-1-1-1
        int[] res = whereWillTheBallFall.findBall(grid);
        Arrays.stream(res).forEach(System.out::print);
    }

    public int[] findBall(int[][] grid) {
        int row = grid.length;
        int coll = grid[0].length;
        int[] ans = new int[coll];
        for (int i = 0; i < row; i++) {
            int currentPosition = i;
            int nextPosition = -1;
            for (int j = 0; j < coll; j++) {
                nextPosition = currentPosition + grid[j][currentPosition]; // 1 = right and -1 = left
                if (nextPosition < 0 || nextPosition >= row || grid[j][currentPosition] != grid[j][nextPosition]) {
                    currentPosition = -1;
                    break;
                }
                currentPosition = nextPosition;
            }
            ans[i] = currentPosition;
        }
        return ans;
    }
}

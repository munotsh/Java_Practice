package com.example.graph;

public class LongestIncreasingPathInMatrix {

    int[][] DIRECTION = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};// down, up,right and left

    public static void main(String[] args) {
        //DFS+memoization for increasing performance.
        // T:O(row*col) and S:o(row*col)
        LongestIncreasingPathInMatrix longestIncreasingPathInMatrix = new LongestIncreasingPathInMatrix();
        int[][] matrix = {{9, 9, 4}, {6, 6, 8}, {2, 1, 1}};
        int result = longestIncreasingPathInMatrix.longestIncreasingPath(matrix);
        System.out.println(result);
    }

    private int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return 0;

        int row = matrix.length;
        int col = matrix[0].length;
        int longPath = 0;
        int[][] cache = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int longest = dfs(matrix, cache, row, col, i, j);
                longPath = Math.max(longest, longPath);
            }
        }
        return longPath;
    }

    private int dfs(int[][] matrix, int[][] cache, int row, int col, int i, int j) {
        if (cache[i][j] > 0) return cache[i][j]; // increase performance
        int max = 0;
        for (int[] direction : DIRECTION) {
            int x = direction[0] + i;
            int y = direction[1] + j;
            if (x > -1 && y > -1 && x < row && y < col && matrix[x][y] > matrix[i][j]) {
                int longest = dfs(matrix, cache, row, col, x, y);
                max = Math.max(max, longest);
            }
        }
        cache[i][j] = max + 1;
        return cache[i][j];
    }
}

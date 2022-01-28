package com.example.graph;

import java.util.LinkedList;
import java.util.Queue;

public class TheMaze {
    int[][] DIRECTION = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};// down, up,right and left

    public static void main(String[] args) {
        TheMaze theMaze = new TheMaze();
        // tc -> m*n, sc-> m*n
        // Ball will not stop -> DFS
        // After hitting the wall, ball can go to any of four directions -> BFS
        // int[][] maze = {{0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}, {1, 1, 0, 1, 1}, {0, 0, 0, 0, 0}};
        // int[] start = {0, 4};
        // int[] destination = {4, 4};
        // output : true

        int[][] maze = {{0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}, {1, 1, 0, 1, 1}, {0, 0, 0, 0, 0}};
        int[] start = {0, 4};
        int[] destination = {4, 3};
        // output : false
        System.out.println(theMaze.hasPath(maze, start, destination));
    }

    private boolean hasPath(int[][] maze, int[] start, int[] destination) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        visited[start[0]][start[1]] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (cur[0] == destination[0] && cur[1] == destination[1]) return true;
            for (int[] direction : DIRECTION) {
                int x = cur[0];
                int y = cur[1];
                while (isValid(x + direction[0], y + direction[1], maze)) {
                    x += direction[0];
                    y += direction[1];
                }
                if (!visited[x][y]) {
                    visited[x][y] = true;
                    queue.offer(new int[]{x, y});
                }
            }
        }
        return false;
    }

    private boolean isValid(int x, int y, int[][] maze) {
        return x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] != 1;
    }
}

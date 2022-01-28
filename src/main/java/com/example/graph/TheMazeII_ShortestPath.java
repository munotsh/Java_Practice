package com.example.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class TheMazeII_ShortestPath {
    int[][] DIRECTION = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};// down, up,right and left

    public static void main(String[] args) {
        TheMazeII_ShortestPath theMaze = new TheMazeII_ShortestPath();
        // tc -> m*n, sc-> m*n
        // Ball will not stop
        // After hitting the wall, ball can go to any of four directions -> BFS

        int[][] maze = {{0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}, {1, 1, 0, 1, 1}, {0, 0, 0, 0, 0}};
        int[] start = {0, 4};
        int[] destination = {4, 4};
        // output : 12

        // int[][] maze = {{0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}, {1, 1, 0, 1, 1}, {0, 0, 0, 0, 0}};
        // int[] start = {0, 4};
        // int[] destination = {4, 3};
        // output : -1
        System.out.println(theMaze.shortestDistance(maze, start, destination));
    }

    public int shortestDistance(int[][] maze, int[] start, int[] dest) {
        int[][] distance = new int[maze.length][maze[0].length];
        for (int[] row : distance)
            Arrays.fill(row, Integer.MAX_VALUE);
        distance[start[0]][start[1]] = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            int[] s = queue.remove();
            for (int[] dir : DIRECTION) {
                int x = s[0] + dir[0];
                int y = s[1] + dir[1];
                int count = 0;
                while (x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0) {
                    x += dir[0];
                    y += dir[1];
                    count++;
                }
                if (distance[s[0]][s[1]] + count < distance[x - dir[0]][y - dir[1]]) {
                    distance[x - dir[0]][y - dir[1]] = distance[s[0]][s[1]] + count;
                    queue.add(new int[]{x - dir[0], y - dir[1]});
                }
            }
        }
        return distance[dest[0]][dest[1]] == Integer.MAX_VALUE ? -1 : distance[dest[0]][dest[1]];
    }
}

package com.example.graph;

import java.util.PriorityQueue;

public class TheMazeIII_ShortestPathWithDirection {
    class Point implements Comparable<Point> {
        int x;
        int y;
        int dis;  // distance from ball
        String path;  // directions from ball

        Point(int x, int y, int dis, String path) {
            this.x = x;
            this.y = y;
            this.dis = dis;
            this.path = path;
        }

        // if both ways have shortest distance, they should be ordered lexicographically
        public int compareTo(Point point) {
            return this.dis == point.dis ? this.path.compareTo(point.path) : this.dis - point.dis;
        }
    }

    int[][] DIRECTION = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};// down, up,right and left
    char[] UDLR = {'u', 'd', 'l', 'r'};

    public static void main(String[] args) {
        TheMazeIII_ShortestPathWithDirection theMaze = new TheMazeIII_ShortestPathWithDirection();
        // tc -> m*n, sc-> m*n
        // Ball will not stop
        // After hitting the wall, ball can go to any of four directions -> BFS

        int[][] maze = {{0, 0, 0, 0, 0}, {1, 1, 0, 1, 1}, {0, 0, 0, 0, 0}, {0, 1, 0, 0, 1}, {0, 1, 0, 0, 0}};
        int[] start = {4, 3};
        int[] destination = {0, 1};
        // output : lul

        // int[][] maze = {{0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}, {1, 1, 0, 1, 1}, {0, 0, 0, 0, 0}};
        // int[] start = {0, 4};
        // int[] destination = {4, 3};
        // output : -1
        System.out.println(theMaze.findShortestWay(maze, start, destination));
    }

    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        int rows = maze.length, cols = maze[0].length;
        boolean[][] visited = new boolean[rows][cols];

        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.offer(new Point(ball[0], ball[1], 0, ""));

        while (!pq.isEmpty()) {
            Point position = pq.poll();
            if (position.x == hole[0] && position.y == hole[1]) {
                return position.path;
            }

            for (int i = 0; i < DIRECTION.length; i++) {
                int x = position.x;
                int y = position.y;
                int dis = position.dis;
                String path = position.path;

                // Explore current direction until hitting a wall or the hole
                while (x >= 0 && x < rows && y >= 0 && y < cols && maze[x][y] == 0 && (x != hole[0] || y != hole[1])) {
                    x += DIRECTION[i][0];
                    y += DIRECTION[i][1];
                    dis += 1;
                }
                // if the ball didn't encounter the hole, we need to roll back one step
                // to get the right position that the ball can reach (in range)
                if (x != hole[0] || y != hole[1]) {
                    x -= DIRECTION[i][0];
                    y -= DIRECTION[i][1];
                    dis -= 1;
                }
                if (!visited[x][y]) {
                    visited[position.x][position.y] = true;
                    pq.offer(new Point(x, y, dis, path + UDLR[i]));
                }
            }
        }
        return "impossible";
    }
}

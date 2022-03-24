package com.example.games;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class SnakeGame {
    private List<Integer> xs;
    private List<Integer> ys;
    private HashSet<String> snake;
    private int foodx;
    private int foody;
    private int[][] food;
    private int eaten;
    private int m;
    private int n;
    /** Initialize your data structure here.
     @param width - screen width
     @param height - screen height
     @param food - A list of food positions
     E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    public SnakeGame(int width, int height, int[][] food) {
        xs = new LinkedList<Integer>();
        ys = new LinkedList<Integer>();
        snake = new HashSet<String>();
        this.food = food;
        eaten = 0;
        m = height;
        n = width;
        xs.add(0, 0);
        ys.add(0, 0);
        snake.add(0 + "," + 0);
        if (food != null && food.length > 0) {
            foodx = food[0][0];
            foody = food[0][1];
        }
        else {
            foodx = -1;
            foody = -1;
        }
    }
    private boolean die(int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return true;
        }
        return snake.contains(i + "," + j) && !(i == xs.get(xs.size() - 1) && j == ys.get(ys.size() - 1));
    }

    /** Moves the snake.
     @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
     @return The game's score after the move. Return -1 if game over.
     Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        int hx = xs.get(0), hy = ys.get(0);
        if (direction.equals("U")) {
            hx --;
        }
        else if (direction.equals("L")) {
            hy --;
        }
        else if (direction.equals("R")) {
            hy ++;
        }
        else if (direction.equals("D")) {
            hx ++;
        }
        else {
            System.out.println("wrong move");
        }
        if (die(hx, hy)) {
            return -1;
        }
        if (!(hx == foodx && hy == foody)) {
            xs.add(0, hx);
            ys.add(0, hy);
            snake.remove(xs.get(xs.size() - 1) + "," + ys.get(ys.size() - 1));
            snake.add(hx + "," + hy);
            xs.remove(xs.size() - 1);
            ys.remove(ys.size() - 1);
            return eaten;
        }
        eaten ++;
        xs.add(0, hx);
        ys.add(0, hy);
        snake.add(hx + "," + hy);
        if (food != null && eaten < food.length) {
            foodx = food[eaten][0];
            foody = food[eaten][1];
        }
        else {
            foodx = -1;
            foody = -1;
        }
        return eaten;
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */
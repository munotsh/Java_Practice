package com.example.games;

public class DesignATicTacToeGame {
    int[] rows;
    int[] cols;
    int diagonal;
    int antiDiagonal;

    public DesignATicTacToeGame(int n) {
        rows = new int[n];
        cols = new int[n];
    }

    public int move(int row, int col, int player) {
        int intPlayer = player == 1 ? 1 : -1;
        rows[row] += intPlayer;
        cols[col] += intPlayer;
        if (row == col) diagonal += intPlayer;
        if (row == rows.length - col - 1) antiDiagonal += intPlayer;
        int size = rows.length;
        if (Math.abs(rows[row]) == size
                || Math.abs(cols[col]) == size
                || Math.abs(diagonal) == size
                || Math.abs(antiDiagonal) == size) {
            return player;
        }
        return 0;
    }
}

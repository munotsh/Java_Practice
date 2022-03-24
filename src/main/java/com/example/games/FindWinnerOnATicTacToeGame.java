package com.example.games;

public class FindWinnerOnATicTacToeGame {
    public static void main(String[] args) {
        FindWinnerOnATicTacToeGame obj = new FindWinnerOnATicTacToeGame();
        //int[][] moves = {{0, 0}, {2, 0}, {1, 1}, {2, 1}, {2, 2}};
        // output : A
        //int[][] moves = {{0, 0}, {1, 1}, {0, 1}, {0, 2}, {1, 0}, {2, 0}};
        // output : B
        int[][] moves = {{0,0},{1,1},{2,0},{1,0},{1,2},{2,1},{0,1},{0,2},{2,2}};
        //output : Draw
        System.out.println(obj.tictactoe(moves));
    }

    public String tictactoe(int[][] moves) {
        String[][] board = new String[3][3];
        //populate
        if (moves.length < 5)
            return "Pending";

        for (int i = 0; i < moves.length; i++) {
            if (i % 2 == 0) // X
                board[moves[i][0]][moves[i][1]] = "A";
            else // O
                board[moves[i][0]][moves[i][1]] = "B";
        }
        //check
        // top
        String check = board[0][0];
        if (check != null) {
            if (board[1][1] == check)
                if (board[2][2] == check)
                    return check;
            if (board[0][1] == check)
                if (board[0][2] == check)
                    return check;
            if (board[1][0] == check)
                if (board[2][0] == check)
                    return check;
        }
        // mid
        check = board[1][1];
        if (check != null) {
            if (board[0][1] == check)
                if (board[2][1] == check)
                    return check;
            if (board[1][0] == check)
                if (board[1][2] == check)
                    return check;
            if (board[0][2] == check)
                if (board[2][0] == check)
                    return check;
        }
        //bottom
        check = board[2][2];
        if (check != null) {
            if (board[2][1] == check)
                if (board[2][0] == check)
                    return check;
            if (board[0][2] == check)
                if (board[1][2] == check)
                    return check;
        }
        if (moves.length == 9)
            return "Draw";
        else
            return "Pending";
    }
}

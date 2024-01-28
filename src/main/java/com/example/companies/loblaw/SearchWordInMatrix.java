package com.example.companies.loblaw;
//This problem is solved using backtracking.
//Find first character of given string by linear search in given matrix
//start backtracking in all four directions until we find all the letters of sequentially adjacent cells
//Edge cases: find stopping condition, we can stop or return false if we reach the end of the boundaries of the matrix
// or the letter at which we are making recursive calls is not the required letter.
//Also, we will return if we found all the letters of the given word


public class SearchWordInMatrix {
    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}};
        SearchWordInMatrix searchWordInMatrix = new SearchWordInMatrix();

        System.out.println(searchWordInMatrix.exist(board, "ABCCED"));
        System.out.println(searchWordInMatrix.exist(board, "SEE"));
        System.out.println(searchWordInMatrix.exist(board, "ABCB"));
    }
    public boolean exist(char[][] board, String word) {

        int m = board.length;
        int n = board[0].length;
        int index = 0;
        // First search the first character
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(index)) {
                    if (searchNext_DFS(board, word, i, j, index))
                        return true;
                }
            }
        }
        return false;
    }

    private boolean searchNext_DFS(char[][] board, String word, int row, int col,
                               int index) {
        // if index reaches at the end that means we have found the word
        if (index == word.length())
            return true;
        // Checking the boundaries if the character at which we are placed is not
        //the required character
        if (row < 0 || col < 0 || row == board.length || col == board[0].length || board[row][col] !=
                word.charAt(index) || board[row][col] == '*')
            return false;
        // this is to prevent reusing of the same character
        char c = board[row][col];
        board[row][col] = '*';
        // top direction
        boolean top = searchNext_DFS(board, word, row - 1, col, index + 1);
        // right direction
        boolean right = searchNext_DFS(board, word, row, col + 1, index + 1);
        // bottom direction
        boolean bottom = searchNext_DFS(board, word, row + 1, col, index + 1);
        // left direction
        boolean left = searchNext_DFS(board, word, row, col - 1, index + 1);
        board[row][col] = c; // undo change
        return top || right || bottom || left;
    }
}

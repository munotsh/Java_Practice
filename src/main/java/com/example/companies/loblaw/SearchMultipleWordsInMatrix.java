package com.example.companies.loblaw;

import java.util.ArrayList;
import java.util.List;
//This problem is solved using backtracking, trie, DFS, we will store word in trie and the
// travers from matrix to check whether word has the match
// we will also change the visited place with '#' so we wont check it again and again for the same word
public class SearchMultipleWordsInMatrix {

    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }
    public static void main(String[] args) {
        char[][] board = {{'o','a','a','n'},
                          {'e','t','a','e'},
                          {'i','h','k','r'},
                          {'i','f','l','v'}};
        String[] words = {"oath","pea","eat","rain"};
//        Output: ["eat","oath"]
        SearchMultipleWordsInMatrix obj = new SearchMultipleWordsInMatrix();
        System.out.println(obj.findWords(board,words));

    }
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs (board, i, j, root, res);
            }
        }
        return res;
    }
    public void dfs(char[][] board, int i, int j, TrieNode p, List<String> res) {
        char c = board[i][j];
        if (c == '#' || p.next[c - 'a'] == null) return;
        p = p.next[c - 'a'];
        if (p.word != null) {
            res.add(p.word);
            p.word = null;
        }

        board[i][j] = '#';
        if (i > 0) dfs(board, i - 1, j ,p, res);
        if (j > 0) dfs(board, i, j - 1, p, res);
        if (i < board.length - 1) dfs(board, i + 1, j, p, res);
        if (j < board[0].length - 1) dfs(board, i, j + 1, p, res);
        board[i][j] = c;
    }

    public TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode p = root;
            for (char c : word.toCharArray()) {
                //a=97, b=98, c=99 d=100 e=101, f=102, g=103, h=104,
                // i=105, j=106, k=107, l=108, m=109, n=110, o=111,
                // p=112, q=113, r=114, s=115, t=116, u=117, v=118,
                // w=119, x=120, y=121, z=122
                int i = c - 'a';
                if (p.next[i] == null) p.next[i] = new TrieNode();
                p = p.next[i];
            }
            p.word = word;
        }
        return root;
    }
}

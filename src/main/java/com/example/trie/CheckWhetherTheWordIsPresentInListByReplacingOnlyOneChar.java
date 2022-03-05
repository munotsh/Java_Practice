package com.example.trie;


public class CheckWhetherTheWordIsPresentInListByReplacingOnlyOneChar {
    class Node {
        char c;
        boolean isWord;
        Node[] children;

        public Node(char c) {
            this.c = c;
            isWord = false;
            children = new Node[26];
        }
    }

    Node root = null;

    public static void main(String[] args) {
        CheckWhetherTheWordIsPresentInListByReplacingOnlyOneChar findWord = new CheckWhetherTheWordIsPresentInListByReplacingOnlyOneChar();
        String search = "applo";
        String[] dictionary = {"apple", "apply", "cat", "dog"};
        System.out.println(findWord.hasWordWithOnlyOneCharReplacement(search, dictionary));
    }

    public CheckWhetherTheWordIsPresentInListByReplacingOnlyOneChar() {
        root = new Node('\0');
    }

    public void insert(String word) {
        Node curr = this.root;
        for (char c : word.toCharArray()) {
            if (curr.children[c - 'a'] == null)
                curr.children[c - 'a'] = new Node(c);
            curr = curr.children[c - 'a'];
        }
        curr.isWord = true;
    }

    private boolean hasWordWithOnlyOneCharReplacement(String search, String[] dictionary) {
        for (String s : dictionary) {
            insert(s);
        }
        search(search);
        return false;
    }

    public boolean search(String word) {
        Node curr = getNode(word);
        return curr != null && curr.isWord;
    }

    public Node getNode(String word) {
        int count = 0;
        Node curr = this.root;
        for (char c : word.toCharArray()) {
//            if (curr.children[c - 'a'] == null) return null;

            curr = curr.children[c - 'a'];
            if(curr.c != c){
                count++;
            }
        }
        return curr;
    }
}

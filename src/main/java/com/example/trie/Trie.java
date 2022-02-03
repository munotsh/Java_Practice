package com.example.trie;

//TC: input: O(m) where the m is number of character in each a word
//SC: for insert O(m) and search and startWith O(1)
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

public class Trie {
    public static void main(String[] args) {
        Trie trie = null;
        String[] instruction = {"Trie", "insert", "search", "search", "startsWith", "insert", "search"};
        String[] values = {"apple", "apple", "app", "app", "app", "app"};
        int j = 0;
        for (int i = 0; i < instruction.length; i++) {
            switch (instruction[i]) {
                case "Trie":
                    trie = new Trie();
                    System.out.println("null");
                    break;
                case "insert":
                    trie.insert(values[j]);
                    System.out.println("null");
                    j++;
                    break;
                case "search":
                    System.out.println(trie.search(values[j]));
                    j++;
                    break;
                case "startsWith":
                    System.out.println(trie.startsWith(values[j]));
                    j++;
                    break;
            }
        }
    }

    Node root = null;

    public Trie() {
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

    public boolean search(String word) {
        Node curr = getNode(word);
        return curr != null && curr.isWord;
    }

    public boolean startsWith(String prefix) {
        return getNode(prefix) != null;
    }

    public Node getNode(String word) {
        Node curr = this.root;
        for (char c : word.toCharArray()) {
            if (curr.children[c - 'a'] == null) return null;
            curr = curr.children[c - 'a'];
        }
        return curr;
    }
}

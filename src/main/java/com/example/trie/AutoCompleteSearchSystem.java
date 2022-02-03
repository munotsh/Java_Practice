package com.example.trie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//time: input: O(x), where x = possible words, constructor: O(mn) m = max length, n = # of words
//space: O(n^2), n = # of possible words, n = # of trie levels; mainlay saving the `Map<S, freq>`
public class AutoCompleteSearchSystem {
    private Trie root;
    private Trie curr;
    private String str; // store currently visiting str

    public static void main(String[] args) {
        String[] sentence = {"i love you","island","ironman","i love leetcode"};
        int[] times = {5,3,2,2};
        AutoCompleteSearchSystem autoCompleteSearchSystem = new AutoCompleteSearchSystem(sentence,times);
        String input = "i a#";
        for(char ch:input.toCharArray()){
            System.out.print(autoCompleteSearchSystem.input(ch));
        }
    }

    public AutoCompleteSearchSystem(String[] sentences, int[] times) {
        root = new Trie();

        for (int i = 0; i < sentences.length; ++i) {
            insert(root, sentences[i], times[i]);
        }

        this.curr = root;
        this.str = "";
    }

    public List<String> input(char c) {
        if (c == '#') {
            insert(root, str, 1);
            curr = root;
            str = "";
            return Collections.EMPTY_LIST;  // return empty as designed
        }

        int i = getIndex(c);
        if (curr.children[i] == null) {
            curr.children[i] = new Trie();
        }

        str += c;
        curr = curr.children[i];
        return getKHot(curr, str, 3);
    }

    private void insert(Trie root, String s, int plusTimes) {
        for (int i = 0; i < s.length(); ++i) {
            int j = getIndex(s.charAt(i));
            if (root.children[j] == null) {
                root.children[j] = new Trie();
            }

            root = root.children[j];
        }

        root.times += plusTimes; // accumulate in case duplicate sentences
    }

    private List<String> getKHot(Trie root, String s, int k) {
        List<Pair> list = new ArrayList<>();
        dfs(root, s, list);
        Collections.sort(list, (a, b) -> (b.times != a.times? b.times - a.times : a.str.compareTo(b.str)));
        List<String> res = new ArrayList<>();

        for (int i = 0; i < Math.min(k, list.size()); ++i) {
            res.add(list.get(i).str);
        }

        return res;
    }

    private void dfs(Trie root, String s, List<Pair> list) {
        if (root.times > 0) {   // add root first
            list.add(new Pair(s, root.times));
        }

        for (char c = 'a'; c <= 'z'; ++c) {
            int i = getIndex(c);
            if (root.children[i] != null) {
                dfs(root.children[i], s + c, list);
            }
        }

        if (root.children[26] != null) {
            dfs(root.children[26], s + ' ', list);
        }
    }

    private int getIndex(char c) {
        return c == ' ' ? 26 : c - 'a';
    }

    class Pair {
        String str;
        int times;

        public Pair(String s, int t) {
            str = s;
            times = t;
        }
    }

    class Trie {
        Trie[] children;
        int times;

        public Trie() {
            children = new Trie[27];
        }
    }
}

package com.example.graph;

import java.util.*;

public class AlienDictionary {
    public static void main(String[] args) {
        AlienDictionary alienDictionary = new AlienDictionary();
        String[] words = {"caa", "aaa", "aab"};
//        String[] words = {"wrt","wrf","er","ett","rftt"};
        System.out.println(alienDictionary.printOrder(words));
    }

    private String printOrder(String[] words) {
        Map<Character, Set<Character>> map = new HashMap<>();
        int[] inDegree = new int[26];
        buildMap(words, map, inDegree);
        String result = dfs(map, inDegree);
        return result;
    }

    private void buildMap(String[] words, Map<Character, Set<Character>> map, int[] inDegree) {
        for (String s : words) {
            for (char c : s.toCharArray()) {
                map.putIfAbsent(c, new HashSet<>());
            }
        }

        for (int i = 1; i < words.length; i++) {
            String first = words[i - 1];
            String second = words[i];

            if (first.length() > second.length() && first.startsWith(second)) {
                map.clear();
                return;
            }

            for (int j = 0; j < first.length(); j++) {
                char key = first.charAt(j);
                char value = second.charAt(j);
                if (key != value) {
                    if (!map.get(key).contains(value)) {
                        inDegree[value - 'a']++;
                        map.get(key).add(value);
                    }
                    break;
                }
            }
        }
    }

    private String dfs(Map<Character, Set<Character>> map, int[] inDegree) {
        StringBuilder sb = new StringBuilder();
        Queue<Character> queue = new LinkedList<>();

        for (char c : map.keySet()) {
            if (inDegree[c - 'a'] == 0) {
                queue.offer(c);
                sb.append(c);
            }
        }

        while (!queue.isEmpty()) {
            char c = queue.poll();
            for (char nextChar : map.get(c)) {
                inDegree[nextChar - 'a']--;
                if (inDegree[nextChar - 'a'] == 0) {
                    queue.offer(nextChar);
                    sb.append(nextChar);
                }
            }
        }
        return sb.length() == map.size() ? sb.toString() : "";
    }
}

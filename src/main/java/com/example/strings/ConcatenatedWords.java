package com.example.strings;

import java.util.*;
import java.util.stream.Collectors;

public class ConcatenatedWords {
    public static void main(String[] args) {
        //Recursion + Memoization o(n*n)
        String[] strArr = {"cat", "dog", "catdog"};
        System.out.println(findAllConcatenatedWordsInADict(strArr));
    }

    public static List<String> findAllConcatenatedWordsInADict(String[] words) {

        if (words == null) return null;

        Set<String> wordsSet = Arrays.stream(words).collect(Collectors.toSet());
        List<String> result = new ArrayList<>();
        Map<String, Boolean> hm = new HashMap<>();
        for (String word : words) {
            if (isConcatenated(word, wordsSet, hm))
            {
                result.add(word);
            }
        }
        return result;
//        return hm.entrySet().stream().filter(Map.Entry::getValue).map(Map.Entry::getKey).collect(Collectors.toList());
    }

    private static boolean isConcatenated(String word, Set<String> wordsSet, Map<String, Boolean> hm) {

        if (hm.containsKey(word)) {
            return hm.get(word);
        }
        for (int i = 0; i < word.length(); i++) {
            String prefix = word.substring(0, i + 1);
            String suffix = word.substring(i + 1, word.length());
            if (wordsSet.contains(prefix) && wordsSet.contains(suffix) || (wordsSet.contains(prefix) && isConcatenated(suffix, wordsSet, hm))) {
                hm.put(word, true);
                return true;
            }
        }
        hm.put(word,false);
        return false;
    }
}

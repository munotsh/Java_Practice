package com.example.allPracticeProgram.ict;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
public class HelloWorld {
	
	static String findLongestWord(String[] words) {
        if (words == null || words.length == 0) return null;
        HashSet map = new HashSet();
        for (String word : words) {
            map.add(word);
        }
        Arrays.sort(words, new Comparator() {
            @Override
            public int compare(String o1, String o2) {
                return ((Integer) o2.length()).compareTo(o1.length());
            }
        });
        for (String word : words) {
            if (isBreakable(word, map)) {
                return word;
            }
        }
        return "";
    }
	private static boolean isBreakable(String word, HashSet set){
        boolean[] res = new boolean[word.length()+1];
        res[0] = true;
        for (int i = 0 ; i < word.length();i++){
            StringBuilder str = new StringBuilder( word.substring(0,i+1) );
            for (int j=0;j <= i;j++){
                if (res[j] && set.contains(str.toString())){
                    res[i+1] = true;
                    break;
                }
                str.deleteCharAt(0);
            }
        }
        return res[word.length()];
    }

}

package com.example.allPracticeProgram.msci;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TextQueries {

	static void textQueries2(String[] sentences, String[] queries) {
        // Split the sentences into terms and map them by index
        Map<Integer, List<String>> sentencesSplit = new HashMap<>();
        for (int j = 0; j < sentences.length; j++) {
            String[] splitSentence = sentences[j].split(" ");
            List<String> sentenceSet = new ArrayList<>();
            sentencesSplit.put(j, sentenceSet);
            for (int i = 0; i < splitSentence.length; i++) {
                sentenceSet.add(splitSentence[i]);
            }
        }

        // Split the query into terms and map them by index
        Map<Integer, String[]> queriesSplit = new HashMap<>();
        for (int i = 0; i < queries.length; i++) {
            queriesSplit.put(i, queries[i].split(" "));
        }

        for (int i = 0; i < queries.length; i++) {
            String found = null;
            for (int j = 0; j < sentences.length; j++) {
                String[] splitQuery = queriesSplit.get(i);
                List<String> sentenceStringList = sentencesSplit.get(j);
                boolean notFound = false;
                for (int k = 0; k < splitQuery.length; k++) {
                	List<Integer> l = new ArrayList<Integer>();
                	for(int h=0;h<sentenceStringList.size();h++) {
                		if (sentenceStringList.get(h).equals(queries[k])) {
//                          notFound = true;
//                          break;
                			l.add(1);
//                			System.out.print(1);
                      }                		
                	}
                	System.out.println(l);
                	
                }
//                if (!notFound) {
//                    if (found == null) {
//                        found = "" + j;
//                    } else {
//                        found += " " + j;
//                    }
//                }
            }
//            if (found == null) {
//                found = "-1";
//            }
//            System.out.println(found);
        }
    }


    public static void main(String[] args) {
//        String[] sentences = {"jim likes mary", "kate likes tom", "tom does not like jim"};
//        String[] queries = {"jim tom", "likes"};
    	
    	String[] sentences = {"bob and alice like to text each other", "bob does not like to ski but does not like to fall", "Alice likes to ski"};
        String[] queries = {"bob alice","alice", "like","non occurrence"};
//    	String[] queries = {"like"};

        textQueries2(sentences, queries);
    }
}

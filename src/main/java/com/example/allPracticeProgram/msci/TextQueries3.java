package com.example.allPracticeProgram.msci;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TextQueries3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> s= new ArrayList<String>();
		List<String> q= new ArrayList<String>();
		s.add("bob and alice like to text each other");
		s.add("bob does not like to ski but does not like to fall");
		s.add("Alice likes to ski");
		q.add("bob alice");
		q.add("alice");
		q.add("like");
		q.add("non occurrence");
		
//String[] sentences = { "bob and alice like to text each other",
//		"bob does not like to ski but does not like to fall", "Alice likes to ski" };
//      String[] queries = {"bob alice","alice", "like","non occurrence"};
//String[] queries = { "like" };

		printAllQeriesIndeicesInSentence(s,q);

	}

	public static void printAllQeriesIndeicesInSentence(List<String> sentences,
            List<String> queries) {
Map<Integer, List<String>> sentenceMap = new HashMap<>();
for(int i=0; i < sentences.size(); i++){
List<String> words = Arrays.asList(sentences.get(i).split("\\s+"));
sentenceMap.put(i, words);
}

for(String query: queries){
List<String> queryList = Arrays.asList(query.split("\\s+"));
for(Map.Entry<Integer, List<String>> e: sentenceMap.entrySet()){
List<String> wordsList = e.getValue();
if(wordsList.containsAll(queryList)){
System.out.print(e.getKey() + " ");
}
}
System.out.println();
}

}

}

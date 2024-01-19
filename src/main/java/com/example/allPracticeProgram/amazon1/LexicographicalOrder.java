package com.example.allPracticeProgram.amazon1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
public class LexicographicalOrder {

	public static void main(String[] args) {
		String[] words = { "Ruby", "C", "Python", "Java" };
	    for(int i = 0; i < 3; ++i) {
	      for (int j = i + 1; j < 4; ++j) {
	        if (words[i].compareTo(words[j]) > 0) {
	          String temp = words[i];
	          words[i] = words[j];
	          words[j] = temp;
	        }
	      }
	    }
	    System.out.println("In lexicographical order:");
	    Arrays.stream(words).forEach(System.out::println);
	    
//		Using java 8
//	    List<String> l = Arrays.stream(words).sorted((s1,s2)->s1.compareTo(s2)).collect(Collectors.toList());
//	    l.forEach(System.out::println);	    
	}
}

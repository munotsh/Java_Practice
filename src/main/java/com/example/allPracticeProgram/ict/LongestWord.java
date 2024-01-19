package com.example.allPracticeProgram.ict;

import java.util.ArrayList;
import java.util.List;

public class LongestWord {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> words = new ArrayList<String>(); 
		words.add("test"); 
		words.add("tester"); 
		words.add("Phenomenologically"); 
		words.add("testertest");
		words.add("testing");
		words.add("TestingTester");
		words.add("TestingTester");
		int longest2 = words.stream() 
                .mapToInt(word -> word.length()) 
                .max() 
                .orElse(0); 
System.out.println(longest2);

	}

}

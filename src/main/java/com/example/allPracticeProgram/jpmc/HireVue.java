package com.example.allPracticeProgram.jpmc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.regex.Pattern;

public class HireVue {

	public static void main(String[] args) throws IOException {
	    InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
	    BufferedReader in = new BufferedReader(reader);
	    
	    String line;
	    while ((line = in.readLine()) != null) {
	      
	      try{
	        // split lines  apart from characters, digits and Underscore
	          String[] words = line.split("[^a-zA-Z0-9_]");
	        // flag for if nothing matched
	           boolean flag = false;
	        // iterate all the words from each line
	          for(String word:words){
	            if(word==null || word.equals(" ")){
	              System.out.println("NONE");
	              continue;
	            }
	            //Case 1 : contains chars, Digits or _
	            if(word.matches("[a-zA-Z0-9_]+")){
	              // case 2 :  starts with capital letter
	              char firstLetter = word.toCharArray()[0];
	              if(firstLetter >='A' && firstLetter <='Z'){
	                // Case 3 : has atleat one digit
	                String regx = "(.)*(\\d)(.)*";
	                Pattern p = Pattern.compile(regx);
	                if(p.matcher(word).matches()){
	                  flag = true;
	                  System.out.println(word);
	                }
	              }
	            }
	          }
	        // if nothing is matched 
	            if(!flag){
	              System.out.println("NONE");
	            }
	          }
	      catch(Exception e){
	        System.out.println("Exception encountered while reading string");
	        e.printStackTrace();
	      }
	    }
	  }

}

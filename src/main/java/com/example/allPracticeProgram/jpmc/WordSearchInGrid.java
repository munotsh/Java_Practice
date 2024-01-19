package com.example.allPracticeProgram.jpmc;

import java.util.ArrayList;
import java.util.List;

public class WordSearchInGrid {

	 public static void main(String []args){
	        final char[][] matrix = {
	                {'X', 'H', 'A', 'T'},
	                {'X', 'E', 'X', 'X'},
	                {'X', 'L', 'X', 'O'},
	                {'X', 'L', 'X', 'W'},
	                {'C', 'O', 'O', 'L'}
	        };

	        String[] searchSequences = {"COOL", "HAT", "HELLO", "OWL", "WORLD"};
	        List<String> wordInMatrix = getWords(matrix);
	        
	        for(String searchSeq:searchSequences) {
	        	for(String word:wordInMatrix) {
	        		if(word.contains(searchSeq)) {
	        			System.out.println(searchSeq);
	        		}
	        	}
	        }
	    }

		private static List<String> getWords(char[][] matrix) {
			List<String> list = new ArrayList<String>();
			for (int i = 0; i < matrix.length; i++) {
				StringBuffer sb = new StringBuffer();
				for (int j = 0; j < matrix.length-1; j++) {
					sb.append(String.valueOf(matrix[i][j]));
				}
				list.add(sb.toString());
			}
			
			for (int i = 0; i < matrix.length-1; i++) {
				StringBuffer sb = new StringBuffer();
				for (int j = 0; j < matrix.length; j++) {
					sb.append(String.valueOf(matrix[j][i]));
				}
				list.add(sb.toString());
			}
			return list;
		}

}

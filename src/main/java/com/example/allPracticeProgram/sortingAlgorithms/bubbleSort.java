package com.example.allPracticeProgram.sortingAlgorithms;

import java.util.Arrays;

public class bubbleSort {

	public static void main(String[] args) {
	        int[] l = {1,4,2,6,7,5};
	        for(int i=0;i<l.length;i++){
	            for(int j=1;j<l.length;j++){
	                if(l[j-1]>l[j]){
	                    int k =l[j];
	                    l[j]=l[j-1];
	                    l[j-1] = k;
	                }
	            }
	        }
	        Arrays.stream(l).forEach(System.out::println);
	}
}

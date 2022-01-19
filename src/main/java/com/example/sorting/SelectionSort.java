package com.example.sorting;

import java.util.Arrays;

public class SelectionSort {

	public static void main(String[] args) {
		int[] l = {1,4,2,6,7,5};
		
		for(int i=0;i<l.length-1;i++) {
			int index = i;
			for(int j=i+1;j<l.length;j++) {
				if(l[j]<l[index]) {
					index = j;
				}
			}
			int temp = l[i];
			l[i]=l[index];
			l[index]= temp;
		}
		
		Arrays.stream(l).forEach(System.out::print);
	}
	
	

}

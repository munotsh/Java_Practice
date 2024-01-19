package com.example.allPracticeProgram.SearchElement;

public class FindAllElementWhosRightElementAreLesser {

	public static void main(String[] args) {
		int[] arr = {1,8,2,6,7,5};
		int max = arr[arr.length-1];
		System.out.println(max);
		for(int i=arr.length-2;i>=0;i--) {
			if(arr[i]>max) {
				System.out.println(arr[i]);
				max = arr[i];
			}
		}
		
	}

}

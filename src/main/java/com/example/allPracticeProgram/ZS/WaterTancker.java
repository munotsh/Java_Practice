package com.example.allPracticeProgram.ZS;

import java.util.Arrays;

public class WaterTancker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] water = {2,2,2};
		int[] capacity = {4,6,4};
		int waterSum = Arrays.stream(water).sum();
//		System.out.println(waterSum);
		
		
		Arrays.sort(capacity);
		reverse(capacity);
//		Arrays.stream(capacity).forEach(System.out::println);
		int count = 0;
		for(int i=0;i<capacity.length;i++) {
			waterSum = waterSum - capacity[i];
			count++;
			if(waterSum <= 0) {
				break;
			}
		}
		System.out.println(count);
//		while(waterSum > 0) {
//			
//		}
	}
	
	 public static void reverse(int[] array)
	    {
	        int n = array.length;
	        for (int i = 0; i < n / 2; i++) {
	            int temp = array[i];
	            array[i] = array[n - i - 1];
	            array[n - i - 1] = temp;
	        }
	    }

}

package com.example.allPracticeProgram.cisco;

import java.util.Arrays;

public class EfficientJenitor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		double[] arr = {1.01, 1.99,2.5, 1.5, 1.01};    
        Arrays.sort(arr);
        int left = 0;
        int right = arr.length - 1;
        int count = 0;
        while(left <= right){
        	
            if(left == right){
                count++;
                break;
            }
            if(arr[left] + arr[right] <= 3.0){
                left++;
                right--;
                count++;
            }
            else{
                right--;
                count++;
            }
        }
        System.out.println(count);
	}

}

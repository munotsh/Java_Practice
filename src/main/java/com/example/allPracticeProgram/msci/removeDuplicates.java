package com.example.allPracticeProgram.msci;

public class removeDuplicates {

	public static void main(String[] args) {
		
//		int nums[] = {1,1,2};
		int nums[] = {0,0,1,1,1,2,2,3,3,4};
		System.out.println(removeDuplicates(nums));
	}
		// TODO Auto-generated method stub
		public static int removeDuplicates(int[] nums) {
		       int j = 0;
		        
		        for(int i = 0; i < nums.length -1 ; i++){
		            if(nums[i] != nums[i + 1]){
		                nums[j] = nums[i];
		                j++;
		            }
		        }
		        nums[j] = nums[nums.length -1];
		            return j+1;

//			int count=0;
//	        for(int i=1;i<nums.length;i++){
//	            if(nums[i]==nums[i-1])
//	                count++;
//	            nums[i-count]=nums[i];
//	        }
//	        return nums.length-count;
		    }
		
		
	}



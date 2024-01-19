package com.example.allPracticeProgram.amazon;

public class MajorityElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a= {2,1,2};
		System.out.println(majorityElement(a));

	}
	public static int majorityElement(int[] nums) {
	    int count = 0, ans = 0;
	    for(int i:nums){
	        if(count == 0)
	            ans = i;
	        if(ans==i)
	            count++;
	        else
	            count--;
	    }
	    return ans;
	}
}

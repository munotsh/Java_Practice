package com.example.allPracticeProgram.morgan_stanley;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StockPairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		List<Integer> arr = new ArrayList<Integer>();
//		arr.add(5);
//		arr.add(7);
//		arr.add(9);
//		arr.add(13);
//		arr.add(11);
//		arr.add(6);
//		arr.add(6);
//		arr.add(3);
//		arr.add(3);
		int target = 12;
		int[] arr = {5,7,9,13,11,6,6,3,3};
System.out.println(uniquePairs(arr, target));
	}
	
	public static int uniquePairs(int[] nums, int target){
        Set<Integer> set = new HashSet<Integer>();
        Set<Integer> seen = new HashSet<Integer>();
        int count = 0;
        for(int num : nums){
            if(set.contains(target-num) && !seen.contains(num)){
                count++;
                seen.add(target-num);
                seen.add(num);
            }
            else if(!set.contains(num)){
                set.add(num);
            }

        }

        return count;
    }

}

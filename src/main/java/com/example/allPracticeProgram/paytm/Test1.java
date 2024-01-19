package com.example.allPracticeProgram.paytm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test1 {
	
	 public static int lastStoneWeight(int[] stones) {
			// We have only one stone so return it
	        if(stones.length==1) return stones[0];
			// We are using a list to add/remove elements ( stones )
	        List<Integer> ls = new ArrayList<>();
			// End when one element ( stone ) left
	        while(ls.size()!=1){
				// Sort elements
	            Arrays.sort(stones);
				// Convert stone array to list
	            ls = Arrays.stream(stones).boxed().collect(Collectors.toList());
				// Get the difference between the last and one before last stones
	            int tmp = ls.get(ls.size()-1)-ls.get(ls.size()-2);
				// Remove the two last stones
	            ls.remove(ls.size()-1); ls.remove(ls.size()-1);
				// Then add the difference between the two as the last stone in the list
	            ls.add(tmp);
				// Convert back to array so we can sort in the next cycle using the java function
	            stones = ls.stream().mapToInt(i->i).toArray();
	        }
			// Return the one stone that's left
	        return ls.get(0);
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//List<Integer> l = new ArrayList<>();
		int[] arr= {2,4,5};
		
//		l.add(2);
//		l.add(4);
//		l.add(5);
		System.out.println(lastStoneWeight(arr));

	}

}

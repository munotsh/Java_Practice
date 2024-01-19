package com.example.allPracticeProgram.common;

import java.util.ArrayList;
import java.util.List;

public class Test9 {

	public static void main(String[] args) {
//List<Integer> list = new ArrayList<Integer>();
//list.add(5);
//list.add(2);
//list.add(3);
//list.add(1);
//list.add(4);

		int[] rating = {5,2,3,1,4};
		int res = 0;
	    for (int i = 1; i < rating.length - 1; ++i) {
	        int less[] = new int[2], greater[] = new int[2];
	        for (int j = 0; j < rating.length; ++j) {
	            if (rating[i] < rating[j])
	                ++less[j > i ? 1 : 0];
	            if (rating[i] > rating[j])
	                ++greater[j > i ? 1 : 0];
	        }
	        res += less[0] * greater[1] + greater[0] * less[1];
	    }
	    return res;

	}

}

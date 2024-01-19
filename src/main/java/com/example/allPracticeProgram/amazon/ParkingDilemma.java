package com.example.allPracticeProgram.amazon;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ParkingDilemma {
	
	static long solution(List<Long>cars, int k) {
		Collections.sort(cars);
	        int start = 0, end = k - 1;
	        long ans = Long.MAX_VALUE;
		for (;end < cars.size(); start++, end++) {
		    ans = Math.min(ans, cars.get(end) - cars.get(start) + 1);
		}
		return ans;
	    }

	    public static void main(String[] args) {
//		int[] cars = {6, 2, 12, 7};
//		int k = 3;
//		int[] cars = {2, 10, 8, 17};
//		int k = 3;
//	    	int[] cars = {1, 2, 3, 10};
//			int k = 4;
		//int[] cars = {2, 10, 8, 17};
		Long[] cars = {new Long(6), new Long(2), new Long(12), new Long(7)};
		int k = 3;
		System.out.println(solution(Arrays.asList(cars), k)); // 5
//		System.out.println(minRoof(cars, k)); // 5
	    }

}

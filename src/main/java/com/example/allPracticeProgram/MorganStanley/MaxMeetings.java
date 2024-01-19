package com.example.allPracticeProgram.MorganStanley;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaxMeetings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Integer> firstDay = new ArrayList<Integer>();
		List<Integer> lastDay  = new ArrayList<Integer>();
		firstDay.add(1);
		firstDay.add(1);
		firstDay.add(2);
		
		lastDay.add(3);
		lastDay.add(2);
		lastDay.add(4);
		
		int max = 0;
		for(int i =0;i<firstDay.size();i++) {
			if(!firstDay.contains(lastDay.get(i))) {
				max =1;
			}
			else {
				int index = firstDay.indexOf(lastDay.get(i));
				
			}
		}
		
//		 Map<Integer, Integer> bookedCalendar = new HashMap<Integer, Integer>();
//	        List<Integer> tempList =  new ArrayList<>();
//
//	        tempList.addAll(firstDay);
//	        tempList.addAll(lastDay);
//
//	        Collections.sort(tempList);
//
//	        int minDay = tempList.get(0);
//	        int maxDay = tempList.get(tempList.size()-2);
//	        System.out.println(minDay);
//	        for(int i=minDay; i<=maxDay; i++)
//	        {
//	            bookedCalendar.put(i, -1);
//	        }
//
//	        System.out.println( bookedCalendar);

	    }
	
	

}

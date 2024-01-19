package com.example.allPracticeProgram.morgan_stanley;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {

	public static void main(String[] args) {
		
	//	MyOuter.MyInner m= new MyOuter.MyInner();
		// TODO Auto-generated method stub
		List<Integer> start = new ArrayList<Integer>();
		List<Integer> end = new ArrayList<Integer>();
//		start.add(1);
//		start.add(1);
//		start.add(2);
//		start.add(3);
//
//		end.add(2);
//		end.add(3);
//		end.add(3);
//		end.add(4);
////		start.add(1);
////		start.add(1);
////		start.add(2);
////		start.add(3);
////		
////		end.add(2);
////		end.add(3);
////		end.add(3);
////		end.add(4);
//
		
		start.add(6);
		start.add(1);
		start.add(2);
		start.add(4);

		end.add(8);
		end.add(9);
		end.add(4);
		end.add(7);
		int meetings = start.size();
		
		int fmax=0;
		for (int i = 0; i <meetings; i++) {
			int max = 1;
			int eachEnd = end.get(i);
			for (int j = i + 1; j <meetings; j++) {
				int eachStart = start.get(j).intValue();
				if (eachEnd <= eachStart) {
					max++;
					eachEnd = eachStart;
				}
			}
			fmax = Integer.max(fmax, max);
		}
		
		System.out.println(fmax);
//		
//		System.out.println(getBaseBookedCalendar(start,end));
		

	}
//	
	public static int getBaseBookedCalendar(List<Integer> firstDay, List<Integer> lastDay){
        Map<Integer, Integer> bookedCalendar = new HashMap<Integer, Integer>();
        List<Integer> tempList =  new ArrayList<>();

        tempList.addAll(firstDay);
        tempList.addAll(lastDay);

        Collections.sort(tempList);

        int minDay = tempList.get(0);
        int maxDay = tempList.get(tempList.size()-2);
//        System.out.println(minDay);
        for(int i=minDay; i<=maxDay; i++)
        {
            bookedCalendar.put(i, -1);
        }

        return bookedCalendar.size();

//   
		}
		
		
}

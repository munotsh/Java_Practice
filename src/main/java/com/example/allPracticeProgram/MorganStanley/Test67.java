package com.example.allPracticeProgram.MorganStanley;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test67 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//int[] start = {1,3,3,5,7};
//int[] du = {1,3,3,5,7};

		List<Integer> start = new ArrayList<Integer>();
		List<Integer> dur = new ArrayList<Integer>();

//		start.add(1);
//		start.add(1);
//		start.add(2);
//		start.add(3);
//
//		dur.add(2);
//		dur.add(3);
//		dur.add(3);
//		dur.add(4);
		
		
//		start.add(1);
//		start.add(1);
//		start.add(2);
//		
//		dur.add(3);
//		dur.add(2);
//		dur.add(4);
		
		
//		start.add(6);
//		start.add(1);
//		start.add(2);
//		start.add(3);
//
//		dur.add(8);
//		dur.add(9);
//		dur.add(4);
//		dur.add(7);
		
		
		start.add(64);start.add(306);start.add(250);start.add(597);start.add(461);start.add(170);start.add(614);start.add(249);start.add(195);start.add(34);
		dur.add(645);dur.add(718);dur.add(626);dur.add(857);dur.add(496);dur.add(274);dur.add(646);dur.add(544);dur.add(386);dur.add(43);
		int max = 1;
		
		for (int i = 0; i < start.size(); i++) {
			int count = 1;
			int newEnd = dur.get(i);
			for (int j =0; j < start.size(); j++) {
				if (newEnd <= start.get(j)) {
					count++;
					newEnd = dur.get(j);
				}

			}
			if(max<count) {
				max = count;
			}
		}
		
		System.out.println(max);

//		System.out.println(num_maxEvents(start, dur));
//		start.add(1);
//		start.add(3);
//		start.add(5);
//		
//		
//		
//		dur.add(2);
//		dur.add(2);
//		dur.add(2);
//		int n=3;

//		start.add(1);
//		start.add(1);
//		start.add(1);
//		start.add(1);
//		start.add(4);
//		
//		
//		
//		dur.add(10);
//		dur.add(3);
//		dur.add(6);
//		dur.add(4);
//		dur.add(2);
//		int n=5;

//		int count =1;
//		int s = start.get(0)+dur.get(0);
//		for(int i=1;i<n;i++) {
//			
//			if(s>=(start.get(i)+dur.get(i))) {
//				s= start.get(i)+dur.get(i);
//			}
//			
//		 	if(start.get(i)>=s) {
//		 		count++;
//		 		s = start.get(i)+dur.get(i);
//		 	}
//		}

//		System.out.println(count);
//		System.out.println(num_maxEvents(start,dur));

//		Map<String,Integer> map = new HashMap<String, Integer>();
//		String a ="abc";
//		String b =new String("abc");
//		map.put(a, 10);
//		map.put(b, 20);
//		map.put(new String("abc"), 30);
//		System.out.println(map.get("abc"));
	}

	public static int num_maxEvents(List<Integer> arr, List<Integer> dur) {
		int drop = 0;
		int NumOfEvents = arr.size();
		int[][] intervals = new int[NumOfEvents][2];

		for (int i = 0; i < NumOfEvents; i++) {
			intervals[i] = new int[] { arr.get(i), arr.get(i) + dur.get(i) };
		}

		Arrays.sort(intervals, (a, b) -> (a[1] - b[1]));
		// the finish time of first event;
		int curTime = intervals[0][1];

		for (int i = 1; i < NumOfEvents; i++) {
			int[] toSchedual = intervals[i];
			if (toSchedual[0] < curTime)
				drop++;
			else {
				curTime = toSchedual[1];
			}
		}
		return NumOfEvents - drop;

	}
}

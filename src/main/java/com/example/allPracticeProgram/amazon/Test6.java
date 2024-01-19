package com.example.allPracticeProgram.amazon;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Test6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] s = { 1, 1, 2 };
//		int[] e = { 3, 2, 4 };
		// 2
		
		int[] s = { 1, 1, 2, 3 };
		int[] e = { 2, 3, 3, 4 };
//		3
//		int[] s = { 6, 1, 2, 3};
//		int[] e = { 8, 9, 4, 7 };
		int max = 1;
		int fmax = 0;
		for(int i=0;i<s.length;i++) {
			int startEnd = e[i];
			max = 1;
			for(int j=i+1;j<e.length;j++) {
				if(startEnd<=s[j]) {
					startEnd = s[j];
					max++;
				}
				
			}
			fmax = Math.max(max, fmax);
		}
		System.out.println(fmax);
		
		
		
		
		
		
		
//		int[][] events = new int[s.length][2];
//		for (int i = 0; i < s.length; i++) {
//			events[i][0] = s[i];
//			events[i][1] = e[i];
//		}

//		Set<Integer> set = new HashSet<Integer>();
//
//		Arrays.sort(events, (a, b) -> (a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]));
//
//		for (int i = 0; i < events.length; i++) {
//			for (int j = events[i][0]; j <= events[i][1]; j++) {
//				if (set.add(j))
//					break;
//			}
//
//		}
//
//		System.out.println(set.size());
		
//		Arrays.sort(events, Comparator.comparingInt(e1->e[0]));
//        PriorityQueue<Integer> minHeap = new PriorityQueue<>();  // end date Heap
//        
//        
//        int event = 0;
//        int attended = 0;
//        for (int day = 1; event< events.length || !minHeap.isEmpty(); day++) {
//            
//			// remove finished event. debug it.
//            while (!minHeap.isEmpty() && minHeap.peek() < day) {
//                minHeap.poll();
//            }
//            
//            if (event< events.length && minHeap.isEmpty()) {
//                day = Math.max(day, events[event][0]); // optimization for next event day
//            }
//            // add today's event . Suppose, (1,2) (1,2) adds them twice into minHeap.
//            while(event < events.length &&events[event][0] == day) { 
//                minHeap.add(events[event][1]);
//                event++;
//            }
//			// dont miss the one ending first . Suppose (5,6) and (5,9), count that (5, 6) first
//            if (!minHeap.isEmpty()) {
//                attended ++;
//                minHeap.poll();
//            }
//            
//        }
//         System.out.println(attended);
    }


}

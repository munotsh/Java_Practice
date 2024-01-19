package com.example.allPracticeProgram.heapSorting;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class TopKElementAlgo {

	public static void main(String[] args) {

		int[] arr = {1,2,3,1,2,1};
		int k =2;
		findTopKElements(arr,k);
	}

	private static void findTopKElements(int[] arr, int k) {
		PriorityQueue<Entry<Integer, Integer>> prio = new PriorityQueue<>((a, b) -> b.getValue().compareTo(a.getValue()));
		Map<Integer, Integer> map =  new HashMap<Integer, Integer>();
		
		for(int a: arr) {
		map.put(a, map.getOrDefault(a,0)+1);	
		}
		System.out.println(map);
		prio.addAll(map.entrySet());
	
		
		
		Iterator<Entry<Integer, Integer>> itr = prio.iterator();
		for(int i=0;i<k;i++) {
			System.out.println(prio.poll().getKey());
		}
	}
	
}
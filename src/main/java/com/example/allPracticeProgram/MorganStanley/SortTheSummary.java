package com.example.allPracticeProgram.MorganStanley;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class SortTheSummary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> arr = new ArrayList<Integer>();
		arr.add(3);
		arr.add(3);
		arr.add(1);
		arr.add(2);
		arr.add(1);
		System.out.print(groupSort(arr));
	}

	public static List<List<Integer>> groupSort(List<Integer> arr) {

		HashMap<Integer, Integer> map = new HashMap<>();
		PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>(
				(e1, e2) -> e2.getValue() == e1.getValue() ? e1.getKey() - e2.getKey() : e2.getValue() - e1.getValue());
		List<List<Integer>> res = new ArrayList<>();
		for (int num : arr) {
			map.putIfAbsent(num, 0);
			map.put(num, map.get(num) + 1);
		}
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			heap.add(entry);
		}
		while (!heap.isEmpty()) {
			Map.Entry<Integer, Integer> entry = heap.poll();
			List<Integer> list = new ArrayList<>();
			list.add(entry.getKey());
			list.add(entry.getValue());
			res.add(list);
		}

		return res;
	}
}

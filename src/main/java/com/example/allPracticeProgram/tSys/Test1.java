package com.example.allPracticeProgram.tSys;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test1 {

	public static void main(String[] args) {
		List<Long> l = new ArrayList<Long>();
//		l.add((long) 1);
//		l.add((long) 1);
//		l.add((long) 2);
//		l.add((long) 2);
//		l.add((long) 3);
		
//		l.add((long) 1);
//		l.add((long) 2);
//		l.add((long) 4);
//		l.add((long) 11);
//		l.add((long) 12);
//		l.add((long) 8);

		
		l.add((long) 2);
		l.add((long) 8);
		l.add((long) 4);
		l.add((long) 6);
		l.add((long) 5);
		Collections.sort(l);
		long b = 2;
		for (Long lo : l) {
			if (lo == b) {
				b = b * 2;
			}
		}
		System.out.println(b);
	}

}

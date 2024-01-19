package com.example.allPracticeProgram.jpmc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

public class comparableExample {

	public static void main(String[] args) {
		List<Integer> l =new ArrayList<>();
		l.add(3);
		l.add(1);
		l.add(0);
		l.add(5);
		l.add(4);
		l.add(2);
		Collections.sort(l,(i,j) -> j.compareTo(i));
		System.out.println(l);
		
		
//		TreeSet<Integer> t = new TreeSet<>((o1,o2)->(o1<o2)?-1:(o1>o2)?1:0);
		TreeSet<Integer> t = new TreeSet<>((o1,o2)-> -o1.compareTo(o2));
//		TreeSet<Integer> t = new TreeSet<>((o1, o2) -> (o1 > o2) ? -1 : (o1 < o2) ? 1 : 0);
//		TreeSet t = new TreeSet();
		t.add(new Integer(3));
		t.add(new Integer(1));
		t.add(new Integer(0));
		t.add(new Integer(5));
		t.add(new Integer(4));
		t.add(new Integer(2));
		
		System.out.println(t);

	}

}

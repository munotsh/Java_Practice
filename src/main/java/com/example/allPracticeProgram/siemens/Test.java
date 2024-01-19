package com.example.allPracticeProgram.siemens;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.stream.IntStream;

import org.w3c.dom.css.Counter;

public class Test {

	public static void main(String[] args) {
//		String st1 = "xyz";
//		String st2 = "xyz";
//
//		System.out.println(st1 == st2);
//		System.out.println(st1.equals(st2));

//		SOP(st1.equals(st2))  true
//		SOP(st1 == st2) true
		
		
//		ArrayList<String> list = new ArrayList<String>();
//		list.add("Shailesh");
//		list.add("Neha");
//		list.add("Vaibhav");
//		list.add("Gaurav");
//		int i=1;
//		Iterator<String> itr =  list.iterator();
//		while(true) {
//
//			if(itr.hasNext()){
//			System.out.println(itr.next());
//			i++;
//			}
//			
//			else {
//				itr = list.iterator();
//			}
//			if(i<=10) {
//				continue;
//			}
//				break;
//		}
		
		
		ArrayList<Integer> l = new ArrayList<Integer>();
//		for(int i=1;i<100;i++) {
//			l.add(e)
//		}
		IntStream.range(1, 100).forEach(i-> l.add(i));
		Spliterator<Integer> sp = l.spliterator();
		int search = 7;
		
	while(sp.estimateSize() >= 1) {
		
	}
		
		
		
	}

}


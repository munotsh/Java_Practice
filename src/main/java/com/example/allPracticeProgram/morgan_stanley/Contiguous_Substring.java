package com.example.allPracticeProgram.morgan_stanley;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Contiguous_Substring {
//	https://www.chegg.com/homework-help/questions-and-answers/1-contiguous-substrings-artist-
//	creating-collage-newspaper-cut-outs-long-string-text-newspa-q66172861
	public static void main(String[] args) {
	List<Integer> s = new ArrayList<Integer>();
	List<Integer> e = new ArrayList<Integer>();
	
//	s.add(1);
//	s.add(1);
//	s.add(6);
//	s.add(7);
//	
//	e.add(5);
//	e.add(3);
//	e.add(8);
//	e.add(10);
	
	s.add(3);s.add(1);s.add(2);s.add(8);s.add(8);
	
	e.add(5);e.add(3);e.add(7);e.add(10);e.add(10);
	int count =0;
	for(int i=0;i<s.size();i++) {
		Set<Integer> set = new HashSet<Integer>();
		for(int j=i+1;j<s.size();j++) {
			if(e.get(i) < s.get(j) && !set.contains(s.get(j))) {
				set.add(s.get(j));
				System.out.println((i+1) +  " = " +(j+1));
				count++;
			}
		}
	}
	System.out.println(count);
	}

}

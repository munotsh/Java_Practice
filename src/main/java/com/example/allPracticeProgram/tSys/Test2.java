package com.example.allPracticeProgram.tSys;

import java.util.Set;
import java.util.TreeSet;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String f = "one";
		String m = "two";
		String l = "three";
		
		Set<String> s1 = new TreeSet<String>();
		s1.add(f);
		s1.add(m);
		s1.add(l);
		StringBuffer sb = new StringBuffer();
		s1.stream().forEach(s -> sb.append(s));
		System.out.println(sb.toString());
	}

}

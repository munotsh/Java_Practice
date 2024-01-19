package com.example.allPracticeProgram.morgan_stanley;

import java.util.ArrayList;
import java.util.List;

public class MoganStanleyTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> l = new ArrayList<String>();
		String string = "A";
		l.add(string);
		l.add("B");
		for(int i=0;i<l.size();i++) {
			if(l.get(i).equals(string)) {
				l.remove(string);
			}
		}
		
		System.out.println(l);

	}

}

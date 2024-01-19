package com.example.allPracticeProgram.morgan_stanley;

import java.util.ArrayList;
import java.util.List;

public class TableOfContaint {

	public static void main(String[] args) {

	List<String> text = new ArrayList<String>();
	text.add("# a");
	text.add("## b");
	text.add("asgdjh");
	text.add("## c");
	text.add("asgdjh");
	text.add("# d");
	text.add("## e");
	text.add("asgdjh");
	text.add("## f");
	text.add("asgdjh");
//	List<String> result = new ArrayList<String>();
int index = 0;
int subIndex = 1;
	for(String s:text) {
		boolean flag = true;
		if(s.startsWith("## ")) {
			System.out.println(index+"."+subIndex+s.substring(2));
			subIndex++;
			flag = false;
		}
		if(flag && s.startsWith("# ")) {
			index++;
			System.out.println(index+"."+s.substring(2));
			subIndex=1;
			
		}
		
	}
	}

}

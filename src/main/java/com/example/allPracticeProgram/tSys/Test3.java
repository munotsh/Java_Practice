package com.example.allPracticeProgram.tSys;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test3 {

	public static void main(String[] args) {
List<Integer> list = new ArrayList<Integer>();
list.add(5);
list.add(1);
list.add(3);
list.add(7);
list.add(3);
		
Collections.sort(list);
System.out.println(list);
int first = list.get(0);
int sum =0;
for(int i=1;i<list.size();i++) {
	sum += Math.abs(first - list.get(i));
	first = list.get(i);
}
System.out.println(sum);
	}

}

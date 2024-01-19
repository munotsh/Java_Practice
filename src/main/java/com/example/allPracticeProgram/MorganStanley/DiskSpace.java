package com.example.allPracticeProgram.MorganStanley;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DiskSpace {

	public static void main(String[] args) {
		 int[] sp =  {8,5,4,6,1};
		 System.out.println(segment(2, sp));
	}

	private static int segment(int seg, int[] sp) {
	if(seg == 0) {
		return 0;
	}
	if(seg == 1) {
		Arrays.sort(sp);
		return sp[sp.length-1];
	}
		int max=0;
		for(int i=0;i<sp.length;i++) {
			List<Integer> l = new ArrayList<Integer>();
			for(int j=i;j<=i+(seg) && j<sp.length;j++) {
				l.add(sp[j]);
			}
			if(l.size() == seg) {
			int max1 = Collections.min(l);
			if(max<max1) {
				max = max1;
			}}
		}
		return max;
	}

}

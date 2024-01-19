package com.example.allPracticeProgram.MorganStanley;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrisonBreakTwo {
	
	public static long prison(int n, int m, List<Integer> h, List<Integer> v) {
        
		int xs = h.stream().min(Integer::compareTo).get();
		int ys = v.stream().min(Integer::compareTo).get();
		
        return (long)(xs+1)*(ys+1);

    }

	public static void main(String[] args) {
		List<Integer> lst1= new ArrayList<>();
        List<Integer> lst2= new ArrayList<>();
           System.out.println(prison(3,2, Arrays.asList(1,2,3), Arrays.asList(1,2)));
        // System.out.println(prison(2,2, Arrays.asList(), Arrays.asList()));
        // System.out.println(prison(3,3, Arrays.asList(2), Arrays.asList(2)));
        System.out.println(prison(4,3,Arrays.asList(1,3), Arrays.asList(2,3)));
	}

}

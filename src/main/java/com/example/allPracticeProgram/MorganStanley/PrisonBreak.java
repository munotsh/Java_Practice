package com.example.allPracticeProgram.MorganStanley;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrisonBreak {
    public static long prison(int n, int m, List<Integer> h, List<Integer> v) {
        // Write your code here
        boolean[] xs = new boolean[n+1];

        boolean[] ys = new boolean[m+1];

        for(Integer i: h) {
            xs[i] = true;
        }

        for(Integer i: v) {
            ys[i] = true;
        }

        int xm = 0, ym =0;

        for(int i = 1, j=0 ; i <= n ;i++) {
        	if(!xs[i]) {
                j =0;
            }else {
                xm = Math.max(xm, ++j);
            }
        }

        for(int i = 1, j=0 ; i <= m ;i++) {
            if(!ys[i]) {
                j =0;
            }else {
                ym = Math.max(ym, ++j);
            }
        }

        return (long)(xm+1)*(ym+1);

    }
    public static void main(String[] args) {
        List<Integer> lst1= new ArrayList<>();
        List<Integer> lst2= new ArrayList<>();
//           System.out.println(prison(3,2, Arrays.asList(1,2,3), Arrays.asList(1,2)));
        // System.out.println(prison(2,2, Arrays.asList(), Arrays.asList()));
        // System.out.println(prison(3,3, Arrays.asList(2), Arrays.asList(2)));
           System.out.println(prison(4,3,Arrays.asList(1,3), Arrays.asList(2,3)));
    }
}

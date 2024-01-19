package com.example.allPracticeProgram.common;

public class MovieRatings {

	public static void main(String[] args) {
		int[] arr = { 9, -1, -3, -1,4, 5 };
		countSum(arr);
	}
	public static void countSum(int[] a) {
        int count = 0;
        int skip = 0;
        int newCount = 0;

        if(a.length==1)
        {
            count = a[0];
        }
        else
        {
            for(int i:a)
            {
                newCount = count + i;   //9 8 5  9 14
                if(newCount>=skip)
                {
                    count = newCount;  //9       9 14
                    skip = newCount;   //9       9 14
                }
                else
                {
                    count = skip;     //  9   8
                    skip = newCount;  //  8   5
                }
            }
        }
        System.out.println(count);
}}

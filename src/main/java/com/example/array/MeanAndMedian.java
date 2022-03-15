package com.example.array;

import java.util.Arrays;

public class MeanAndMedian {
    public static void main(String args[])
    {
        int a[] = { 1, 3, 4, 2, 7, 5, 8, 6 };
        int n = a.length;

        System.out.println("Mean = " + findMean(a, n)); // 4.5
        System.out.println("Median = " + findMedian(a, n)); // 4.5
    }

	public static double findMean(int a[], int n)
    {
        int sum = 0;
        for (int i = 0; i < n; i++)
            sum += a[i];
 
        return (double)sum / (double)n;
    }
 
    public static double findMedian(int a[], int n)
    {
        Arrays.sort(a);
 
        if (n % 2 != 0)
            return (double)a[n / 2];
 
        return (double)(a[(n - 1) / 2] + a[n / 2]) / 2.0;
    }
 

}

package com.example.integers;

public class FibonacciExample {
    public static void main(String args[]) {
        fibonacciSeriesUsingLoop();
        System.out.println();
        int count = 10;
        int first = 0;
        int second = 1;
        System.out.print(first + " " + second);
        fibonacciSeriesUsingRecursion(count - 2, first, second);//n-2 because 2 numbers are already printed
    }

    private static void fibonacciSeriesUsingRecursion(int count, int first, int second) {
        if (count > 0) {
            int temp = first + second;
            System.out.print(" "+temp);
            first = second;
            second = temp;
            fibonacciSeriesUsingRecursion(count - 1, first, second);
        }

    }

    private static void fibonacciSeriesUsingLoop() {
        int n1 = 0, n2 = 1, n3, i, count = 10;
        System.out.print(n1 + " " + n2);//printing 0 and 1
        for (i = 2; i < count; ++i)//loop starts from 2 because 0 and 1 are already printed
        {
            n3 = n1 + n2;
            System.out.print(" " + n3);
            n1 = n2;
            n2 = n3;
        }
    }
}

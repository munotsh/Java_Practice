package com.example.allPracticeProgram.public_sapient;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FibonacciSeriesPrimeNumber {
	public static void main(String[] args) {
		//Fibonacci Series
		Stream.iterate(new int[] { 0, 1 }, t -> new int[] { t[1], t[0] + t[1] })
		.limit(10)
		.forEach(e -> System.out.println(e[0]));
		
		//Prime numbers
		IntStream.range(1, 10)
		.filter(i -> FibonacciSeriesPrimeNumber.isPrime(i))
		.forEach(System.out::println);
	}

	private static boolean isPrime(int number) {
		return IntStream.rangeClosed(2, number / 2).noneMatch(i -> number % i == 0);
	}
}

package com.example.threads.callableInterface;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestCallable {

	public static void main(String[] args) {
		JobOfCallable j1= new JobOfCallable(1,10);
		JobOfCallable j2= new JobOfCallable(11,20);
		JobOfCallable j3= new JobOfCallable(21,30);
		
		ExecutorService ex = Executors.newFixedThreadPool(3);
		ex.submit(j1);
		ex.submit(j2);
		ex.submit(j3);

	}

}

package com.example.allPracticeProgram.volatileAndSynchronize;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Test {

	public static void main(String[] args) {
IncrementValue incrementValue = new IncrementValue();;
ExecutorService executorService = Executors.newFixedThreadPool(2);
		try {
			Runnable r1 = () -> {
				for(int i=0;i<10000;i++) {
					incrementValue.setI();
				}
			};
			
			Runnable r2 = () -> {
				for(int i=0;i<10000;i++) {
					incrementValue.setI();
				}
			};
			executorService.submit(r1);
			executorService.submit(r2);
			executorService.awaitTermination(1, TimeUnit.SECONDS);
			System.out.println(incrementValue.getI());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			executorService.shutdown();	
		}
	}

}

package com.example.allPracticeProgram.callableInterface;

import java.nio.file.Files;

public class JobOfCallable implements Runnable{
	int start;
	int end;
	public JobOfCallable(int start,int end) {
		this.start = start;
		this.end = end;
	}
	@Override
	public void run(){
		int i=start;
		while(i<=end) {
			System.out.println(Thread.currentThread().getName()+" = "+i);
			i++;
		}
//		if(i==end)
//		return 1;
//		else
//		return 0;	
		
	}
}

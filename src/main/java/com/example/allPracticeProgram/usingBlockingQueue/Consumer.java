package com.example.allPracticeProgram.usingBlockingQueue;

import java.util.concurrent.BlockingQueue;
public class Consumer extends Thread{
	BlockingQueue<Integer> queue;
	int count=0;
	public Consumer(BlockingQueue<Integer> queue) {
		this.queue = queue;
	}
	@Override
	public void run() {
		while(count!=4) {
			try {
				count = queue.take();
				System.out.println("Consumer " + count);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}

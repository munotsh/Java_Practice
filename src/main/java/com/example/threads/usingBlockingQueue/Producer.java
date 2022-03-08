package com.example.threads.usingBlockingQueue;


import java.util.concurrent.BlockingQueue;

public class Producer extends Thread {
	BlockingQueue<Integer> queue;
	public Producer(BlockingQueue<Integer> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		for (int i = 1; i <= 4; i++) {
			try {
				queue.put(i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Produced " + i);
		}
	}
}

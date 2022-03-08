package com.example.threads.usingBlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Client {
	public static void main(String[] args) {
		BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(4);
		Producer p =new Producer(queue);
		Consumer c = new Consumer(queue);
		p.start();
		c.start();
	}
}

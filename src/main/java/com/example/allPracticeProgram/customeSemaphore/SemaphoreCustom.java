package com.example.allPracticeProgram.customeSemaphore;

public class SemaphoreCustom {

	private int permits;

	public SemaphoreCustom(int permits) {
		this.permits = permits;
	}

	public synchronized void acquire() throws InterruptedException {
		if (permits > 0) {
			permits--;
		} else {
			this.wait();
			permits--;
		}
	}

	public synchronized void release() {
		permits++;

		if (permits > 0)
			this.notify();
	}
}

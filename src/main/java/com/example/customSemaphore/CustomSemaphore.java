package com.example.customSemaphore;

public class CustomSemaphore {
    private int permits;

    public CustomSemaphore(int permits) {
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

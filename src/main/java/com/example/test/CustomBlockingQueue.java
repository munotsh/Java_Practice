package com.example.test;

public class CustomBlockingQueue {
	final Object[] items = new Object[100]; 
    int putIndex, takeIndex, count;

    public synchronized void put(Object x) throws InterruptedException {
        while (count == items.length)
            wait(); 
        items[putIndex] = x;
        if (++putIndex == items.length) putIndex = 0;
        ++count;
        notifyAll();    
    }

    public synchronized Object take() throws InterruptedException {
        while (count == 0)
            wait(); 
        Object x = items[takeIndex];
        if (++takeIndex == items.length) takeIndex = 0;
        --count;
        notifyAll();    
        return x;
    }
}

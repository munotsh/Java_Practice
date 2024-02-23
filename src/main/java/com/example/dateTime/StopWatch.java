package com.example.dateTime;

import com.sun.prism.paint.Stop;

public class StopWatch {
    private boolean isRunning = false;
    private long startTime = 0;
    private long elapsedTime = 0;

    public void start() {
        if (!isRunning) {
            startTime = System.nanoTime();
            isRunning = true;
        }
    }

    public void stop() {
        if (isRunning) {
            isRunning = false;
            elapsedTime = +elapsedTime + (System.nanoTime() - startTime);
        }
    }

    public void reset() {
        elapsedTime = 0;
        if (isRunning) {
            startTime = System.nanoTime();
        }
    }

    public long getElapsedTimeInSeconds() {
        if (isRunning)
            return (System.nanoTime() - startTime) / 1000000000L;
        return elapsedTime / 1000000000L;
    }

    public static void main(String[] args) throws InterruptedException {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Thread.sleep(1000);
        System.out.println(stopWatch.getElapsedTimeInSeconds());
        Thread.sleep(2000);
        System.out.println(stopWatch.getElapsedTimeInSeconds());
        stopWatch.stop();
        System.out.println(stopWatch.getElapsedTimeInSeconds());
        Thread.sleep(1000);
        System.out.println(stopWatch.getElapsedTimeInSeconds());
    }

}

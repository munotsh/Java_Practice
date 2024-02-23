package com.example.dateTime;

import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;

public class StopWatchWithClickEvent implements Runnable {
    static boolean stop = false;

    public static void main(String[] args) {
        StopWatchWithClickEvent stopWatchWithClickEvent = new StopWatchWithClickEvent();
        Instant start = Instant.now();
        new Thread(stopWatchWithClickEvent).start();
        Scanner s = new Scanner(System.in);
        s.nextLine();
        stop = true;
        Instant end = Instant.now();
        Duration duration = Duration.between(start, end);
        System.out.println(duration.getSeconds());
    }

    @Override
    public void run() {
        int seconds = 1;
        while (!stop) {
            System.out.println(seconds + "" + Instant.now());
            seconds++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

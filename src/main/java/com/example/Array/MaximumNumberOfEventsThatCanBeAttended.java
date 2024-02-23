package com.example.Array;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaximumNumberOfEventsThatCanBeAttended {
    public static void main(String[] args) {
        int[][] events = {{1, 2}, {2, 3}, {3, 4},{1,2}};
        System.out.println(maxEvents(events));
    }

    public static int maxEvents(int[][] events) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        //Sorting according to the end day of the event
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));
        //{{1, 2},{1,2},{2, 3},{3, 4}};
        int i = 0, res = 0, n = events.length;
        for (int d = 1; d <= n; d++) {
            while (!pq.isEmpty() && pq.peek() < d) {
            /*this will be the case when some event say [2,3] is in queue and our current day is 4.
            which means end-day for the event [2,3] was 3 and today is day 4 so
            we will just remove it and it won't be attended*/
                pq.poll();
            }
            while (i < n && events[i][0] == d) {
            /*this will be the case when the start day of the event is d.
            for [2,3] it will be 2. and if current day is 2 then we will add this to the queue.
            because if we dont add it on day 2 then when the day 3 comes, we wont be able to add
            [2,3] (because it's start day is 2)*/
                pq.offer(events[i][1]);
            i++;
            }
            if (!pq.isEmpty()) {
                /*Now we have added the events. and we will just poll one element
                and increase the day count so this event is done.
                and we will move to the next event.
                here pq is priority queue sorted according to the end day.
				so the first element in this queue will be the event that is going to end earliest.
                so we will poll it which means it happened and move to the next day.*/
                pq.poll();
                res++;
            }
        }
        return res;
    }
}

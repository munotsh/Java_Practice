package com.example.array;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRooms_ii {
    public static void main(String[] args) {
        MeetingRooms_ii meetingRooms_ii = new MeetingRooms_ii();
        int[][] input = {{1, 3}, {8, 10}, {7, 8}, {9, 15}, {2, 6}};
        //output : 2
        System.out.println(meetingRooms_ii.minMeetingRoom(input));
    }

    private int minMeetingRoom(int[][] intervals) {
        if (intervals == null && intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, (i, j) -> Integer.compare(i[0], j[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int[] interval : intervals) {
            if (pq.isEmpty()) {
                pq.add(interval[1]);
            } else {
                if (pq.peek() > interval[0]) {
                    pq.add(interval[1]); // create new meeting room
                } else {
                    pq.remove(); // remove old and add new meeting in existing meeting
                    pq.add(interval[1]);
                }
            }
        }
        return pq.size();
    }
}

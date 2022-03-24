package com.example.Array;

import java.util.Arrays;

public class CheckIfAPersoneCanAttendsAllTheMeetings {
    public static void main(String[] args) {
        CheckIfAPersoneCanAttendsAllTheMeetings checkIfAPersoneCanAttendsAllTheMeetings = new CheckIfAPersoneCanAttendsAllTheMeetings();
//        int[][] schedule = {{1, 3}, {8, 10}, {7, 8}, {9, 15}};
        //output : false
        int[][] schedule = {{1, 3}, {8, 10}, {7, 8}, {10, 15}};
        //output : true
        System.out.println(checkIfAPersoneCanAttendsAllTheMeetings.canAttendAllTheMeetings(schedule));
    }

    private boolean canAttendAllTheMeetings(int[][] schedules) {
        if (schedules == null && schedules.length == 0)
            return false;
        else {
            Arrays.sort(schedules, (i, j) -> Integer.compare(i[0], j[0]));
            int lastMeetingEndTime = schedules[0][1];
            for (int i = 1; i < schedules.length; i++) {
                if (schedules[i][0] < lastMeetingEndTime) {
                    return false; // there is meeting overlaping
                } else {
                    lastMeetingEndTime = schedules[i][1]; //update end time of next meeting
                }
            }
        }
        return true;
    }
}

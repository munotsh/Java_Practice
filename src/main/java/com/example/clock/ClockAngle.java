package com.example.clock;

//Logic
//Hour Hand:
//    Moves 360° / 12 = 30° per hour
//    Also moves 0.5° per minute (30° / 60)
//Minute Hand:
//    Moves 360° / 60 = 6° per minute

//hour_angle   = 30 * hour + 0.5 * minutes
//minute_angle = 6 * minutes
//angle = abs(hour_angle - minute_angle)
//final_angle = min(angle, 360 - angle)
public class ClockAngle {
    public static void main(String[] args) {
        System.out.println("Angle at 3:30 = " + findAngle(3, 30) + "°");  // 75°
        System.out.println("Angle at 12:00 = " + findAngle(12, 0) + "°"); // 0°
        System.out.println("Angle at 9:45 = " + findAngle(9, 45) + "°");  // 22.5°
        System.out.println("Angle at 9:57 = " + findAngle(9, 57) + "°");  // 22.5°
    }

    private static double findAngle(int hour, int minutes) {
        // Normalize hour to 12-hour format
        hour = hour % 12;

        // Calculate positions
        double hourAngle = 30 * hour + 0.5 * minutes;
        double minuteAngle = 6 * minutes;

        // Find absolute difference
        double angle = Math.abs(hourAngle - minuteAngle);

        // Return the smaller of the two possible angles
        return Math.min(angle, 360 - angle);
    }
}

package com.example.Array;

import java.util.Arrays;

public class CafeteriaWithCovidGuidelinesSeatingArrangements {
    public static void main(String[] args) {
        CafeteriaWithCovidGuidelinesSeatingArrangements cafeteria = new CafeteriaWithCovidGuidelinesSeatingArrangements();
//        int seats = 10;
//        int distance = 1;
//        int numberOfSeatOccupied = 2;
//        long[] occupiedSeatNumber = {2,6};
//        output 3

        int seats = 15;
        int distance = 2;
        int numberOfSeatOccupied = 3;
        long[] occupiedSeatNumber = {11,6,14};
//        output 1

        System.out.println(cafeteria.getMaxAdditionalDinersCount(seats,distance,numberOfSeatOccupied,occupiedSeatNumber));



    }

    public long getMaxAdditionalDinersCount(long N, long K, int M, long[] S) {
        Arrays.sort(S);
        long result = 0;
        long start = 1;
        long end;

        for(int i=0; i<M; ++i) {
            end = S[i] - K - 1;
            result += getCount(start, end, K);
            start = S[i] + K + 1;
        }
        result += getCount(start, N, K);
        return result;
    }

    private long getCount(long start, long end, long K) {
        return start > end ? 0 : (end - start)/(K + 1) + 1;
    }
}

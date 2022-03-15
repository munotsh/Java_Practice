package com.example.array;

public class LastMomentBeforeAllAntsFallOutOfPlank {
    public static void main(String[] args) {
        LastMomentBeforeAllAntsFallOutOfPlank lastMomentBeforeAllAntsFallOutOfPlank = new LastMomentBeforeAllAntsFallOutOfPlank();
//        int n = 4;
//        int[] left = {4, 3};
//        int[] right = {0, 1};
//        OP: 4
        int n = 7;
        int[] left = {};
        int[] right = {0,1,2,3,4,5,6,7};
//        OP:7
        System.out.println(lastMomentBeforeAllAntsFallOutOfPlank.getLastMoment(n, left, right));
    }

    public int getLastMoment(int n, int[] left, int[] right) {
        int maxTime = Integer.MIN_VALUE;
        for (int i = 0; i < left.length; i++) {
            if (left[i] > maxTime) {
                maxTime = left[i];
            }
        }

        for (int i = 0; i < right.length; i++) {
            if (n - right[i] > maxTime) {
                maxTime = n - right[i];
            }
        }
        return maxTime;
    }
}

package com.example.Array;

import java.util.Arrays;

public class PickUpCoinsForMaximumGain {
    public static void main(String[] args) {

        int[] arr = {10, 25, 5, 1, 10, 5};
        System.out.println(pickUpCoins(arr));
    }


    public static int pickUpCoins(int[] C) {
        int[][] T = new int[C.length][C.length];
        for (int[] t : T) {
            Arrays.fill(t, -1);
        }
        return pickUpCoinsHelper(C, 0, C.length - 1, T);
    }

    private static int pickUpCoinsHelper(int[] C, int a, int b,int[][] T) {
        if (a > b) {
            return 0; // Base condition.
        }

        if (T[a][b] == -1) {
            T[a][b] = Math.max(
                    C[a]+ Math.min(pickUpCoinsHelper(C, a + 2, b, T),
                            pickUpCoinsHelper(C, a + 1, b - 1, T)),
                    C[b]
                            + Math.min(pickUpCoinsHelper(C, a + 1, b - 1, T),
                            pickUpCoinsHelper(C, a, b - 2, T))
            );
        }
        return T[a][b];
    }
}

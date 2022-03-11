package com.example.matrix;

import java.util.Arrays;

public class SpiralOrCircularMatrix_II {
    public static void main(String[] args) {
        SpiralOrCircularMatrix_II spiralOrCircularMatrix = new SpiralOrCircularMatrix_II();
        int row = 3;
        int col = 3;
        int[][] mat = spiralOrCircularMatrix.generateMatrix(row, col);
        for(int[] m:mat)
        System.out.println(Arrays.toString(m));
    }

    public int[][] generateMatrix(int row, int col) {
        int[][] mat = new int[row][col];
        int value = 1;

        int[][] matrix = new int[row][col];
        int upper = 0, lower = row-1;
        int left = 0, right = col-1;

        while(value <= row*col) {
            // populate top line
            if(upper <= lower) {
                for(int i = left; i <= right; i++) {
                    matrix[upper][i] = value++;
                }
                upper++;
            }
            if(left <= right) {
                for(int i = upper; i <= lower; i++) {
                    matrix[i][right] = value++;
                }
                right--;
            }
            if(lower >= upper) {
                for(int i = right; i >= left; i--) {
                    matrix[lower][i] = value++;
                }
                lower--;
            }
            if(left <= right) {
                for(int i = lower; i >= upper; i--) {
                    matrix[i][left] = value++;
                }
                left++;
            }
        }

        return matrix;
    }
}

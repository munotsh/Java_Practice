package com.example.meta;

public class Battleship {
    public static double getHitProbability(int R, int C, int[][] G) {
        double count =0;
        for(int[] i:G){
            for(int j:i){
                if(j == 1){
                    count++;
                }
            }
        }
        return count/(R*C);
    }
    public static void main(String[] args){
        int[][] g = {{0,0,1},{1,0,1}};
        System.out.println(getHitProbability(2,3,g));
    }
}

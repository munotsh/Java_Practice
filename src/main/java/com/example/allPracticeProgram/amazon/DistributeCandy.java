package com.example.allPracticeProgram.amazon;

public class DistributeCandy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a= {1,5,2,1};
		System.out.println(candy(a));

	}
	
	public static int candy(int[] ratings) {
        int [] candies = new int [ ratings.length];
        candies[0] = 1;
        for(int i=1;i<ratings.length;i++){
            if(ratings[i] > ratings[i-1]){
                candies[i] = candies[i-1] + 1;
            }else {
                candies[i] = 1;
            }
        }
        int out = candies[candies.length-1];
        for(int i=ratings.length-2;i>=0;i--){
            if(ratings[i] > ratings[i+1]){
                candies[i] = Math.max(candies[i] , candies[i+1] + 1);
            }
            out += candies[i];
        }
        return out;
    }

}

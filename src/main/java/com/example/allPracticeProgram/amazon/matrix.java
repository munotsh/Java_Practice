package com.example.allPracticeProgram.amazon;

public class matrix {

	public static int diagonalSum(int[][] mat) {
        int sum = 0;
        int a = 0;
        int b = mat[0].length-1;
        for(int row = 0; row < mat.length; row++){
            if(b==a){
                sum+=(mat[row][a++]);
                b--;
                continue;
            }       
            sum+= (mat[row][a++]) + (mat[row][b--]);
        }
        return sum;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int N = 3;
			    int arr[][] = { { 1, 2, 3 },
	                      { 4, 5, 6 },
	                      { 2 }};

	   	    System.out.println(diagonalSum(arr));
	}

}

package com.example.matrix;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInBinaryMatrix {
    public static void main(String[] args) {
        ShortestPathInBinaryMatrix obj = new ShortestPathInBinaryMatrix();
        int[][] mat = {{0, 0, 0}, {1, 1, 0}, {1, 1, 0}};
        System.out.println(obj.shortestPathBinaryMatrix(mat));
    }
    public int shortestPathBinaryMatrix(int[][] grid) {

        //all possible 8-direction standing at origin
        int[][] dir={{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1},{-1,0},{-1,1}};

        //end point
        int rmax=grid.length, cmax=grid[0].length;

        //queue for storing coordinates and count of steps
        Queue<int[]> q=new LinkedList<>();

        //checking if possible to enter the grid
        if(grid[0][0]==1) return -1;

        //if possible to enter then adding first cell coordinate and count to queue  :: count will be 1
        q.offer(new int[]{0,0,1});

        //now polling element and checking for its 8-direction possible path
        while(!q.isEmpty()){
            int[] temp=q.poll();
            int r=temp[0],
                    c=temp[1],
                    count=temp[2];

            //check if end is reached
            if(r==rmax-1 && c==cmax-1) return count;

            // checking for its 8-direction possible path
            for(int[] i:dir){
                int r2=r+i[0],
                        c2=c+i[1];

                if(r2>=0 && r2<rmax && c2>=0 && c2<cmax && grid[r2][c2]==0){
                    q.offer(new int[]{r2,c2,count+1});
                    // mark this cell as visited
                    grid[r2][c2]=1;
                }
            }
        }
        return -1;

    }
}

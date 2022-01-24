package com.example.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseScheduleUsingKahnsAlgo {

    public  static void main(String[] args){
        CourseScheduleUsingKahnsAlgo courseSchedule = new CourseScheduleUsingKahnsAlgo();
//        int numCourses = 2;
//        int[][] prerequisites = {{1,0},{0,1}};
//        output = false

        int numCourses = 2;
        int[][] prerequisites = {{1,0}};
//      output = false
        System.out.println(courseSchedule.canFinish(numCourses,prerequisites));
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // First we create the Adjacency ist

        List<Integer>[] adj=new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++){
            adj[i]=new ArrayList();
        }

        //Now we create the indegree array to store the indegrees of vertices

        int[] indegree=new int[numCourses];
        for(int[] i: prerequisites){
            adj[i[0]].add(i[1]);
            indegree[i[1]]++;
        }

        //Now we create a queue cuz of its FIFO nature and store the vertices on the basis of indegree of vertices having 0 indegree.

        Queue<Integer> queue= new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                queue.add(i);
            }
        }
        while(!queue.isEmpty()){
            int current=queue.poll();
            for(int c:adj[current]){
                indegree[c]--;
                if(indegree[c]==0)
                    queue.add(c);
            }
            numCourses--;  // remove dependency of that vertex from the graph.
        }

        return numCourses==0;
    }
}

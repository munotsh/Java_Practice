package com.example.Array;

public class TaskScheduler {
    public static void main(String[] args) {
        TaskScheduler ts = new TaskScheduler();
        char[] task = {'A','A','A','A','A','A','B','C','D','E','F','G'};
        int n = 2;
        System.out.println(ts.leastInterval(task, n));
    }

    public int leastInterval(char[] tasks, int n) {
        int[] charMap = new int[26];
        for(char c:tasks){
            charMap[c-'A']++;
        }

        int max = charMap[0]-1;
        int ideal_slot = max*n;

        for(int i =1;i<25;i++){
            ideal_slot -= Math.min(charMap[i],max);
        }

        return ideal_slot > 0 ? ideal_slot+tasks.length : tasks.length;
    }
}

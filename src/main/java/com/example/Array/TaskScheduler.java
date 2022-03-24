package com.example.Array;

import java.util.Arrays;

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
        Arrays.sort(charMap);
        int max = charMap[25]-1;
        int ideal_slot = max*n;

        for(int i =24;i>=0;i--){
            ideal_slot -= Math.min(charMap[i],max);
        }

        return ideal_slot > 0 ? ideal_slot+tasks.length : tasks.length;
    }
}

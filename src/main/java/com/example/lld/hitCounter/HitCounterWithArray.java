package com.example.lld.hitCounter;

public class HitCounterWithArray {
    int[] ts;
    int[] hits;
    /** Initialize your data structure here. */
    public HitCounterWithArray() {
        ts = new int[300];
        hits = new int[300];
    }
    /** Record a hit.
     @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        int i = timestamp % 300;
        if (ts[i] != timestamp) {
            ts[i] = timestamp;
            hits[i] = 1;
        }
        else {
            hits[i] ++;
        }
    }
    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        int result = 0;
        for (int i = 0; i < hits.length; i ++) {
            if (timestamp - ts[i] < 300){
                result += hits[i];
            }
        }
        return result;
    }
}
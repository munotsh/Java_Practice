package com.example.Array;

import java.util.*;

public class LongestContinuousSubArrayWithAbsoluteDiffLessThanOrEqualToLimit {
    public static void main(String[] args){
        LongestContinuousSubArrayWithAbsoluteDiffLessThanOrEqualToLimit lc =
                new LongestContinuousSubArrayWithAbsoluteDiffLessThanOrEqualToLimit();
        int[] arr = {8,2,4,7};
        int limit = 4;
        System.out.println(lc.longestSubarray(arr,limit));
    }
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> min = new ArrayDeque<>(); // maintains increasing order of the value index. So that min front will always have smallest value.
        Deque<Integer> max = new ArrayDeque<>();// maintains decreasing order of the value index. So that max front will always have the greatest value.
        int size = 0;
        int left =0;
        int right =0;
        while(right < nums.length){
            int val  = nums[right];
            //from behind remove all the index that have values less than val.
            while(!min.isEmpty() && nums[min.peekLast()]>=val)
                min.pollLast();
            //add val index to the end. Hence the increasing order will be maintained
            min.addLast(right);
            while(!max.isEmpty() && nums[max.peekLast()]<=val)
                max.pollLast();
            //add val index to the end. Hence maintaining decreasing order.
            max.add(right);
            int minVal = nums[min.peekFirst()]; // min front will have min value index
            int maxVal = nums[max.peekFirst()]; // max front will have max value index
            if(maxVal - minVal<= limit) {
                size = Math.max(size,right-left+1); // right-left+1 will tell no of elements present in the current subarray
                right++;
            }
            else {
                /*
                As the if condition failed we will increment left index.
                And from the new left index new subarray will start.
                Hence all the indexes less than left should be removed from min and max deque as they are not part of the current subarray.*/
                left++;
                while(left> min.peekFirst())
                    min.pollFirst();
                while(left > max.peekFirst())
                    max.pollFirst();
            }
        }
        return size;
    }
}

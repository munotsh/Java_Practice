package com.example.Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IndexOfTwoSumArray {
    public static void main(String[] args) {
        IndexOfTwoSumArray indexOfTwoSumArray = new IndexOfTwoSumArray();
        int[] arr = {2,7,11,15};
        int target = 9;
        System.out.println(Arrays.toString(indexOfTwoSumArray.twoSum(arr,target)));
    }
    public int[] twoSum(int[] nums, int target) {
        int[] res=new int[2];
        Map<Integer,Integer> temp=new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            if(temp.containsKey(target-nums[i])) {
                res[0]=i;
                res[1]=temp.get(target-nums[i]);
                return res;
            }
            temp.put(nums[i],i);
        }
        return res;
    }
}

package com.example.Array;

import java.util.Arrays;

public class Three3SumClosest {
    public static void main(String[] args) {
        Three3SumClosest obj = new Three3SumClosest();
        // int[] arr = {-1, 2, 1, -4};
        // int target = 1;
        // OP : -1 + -2 + 1 = 2, TC : O(n2)

        int[] arr = {0,0,0};
        int target = 1;
        // OP : 0, TC : O(n2)

        System.out.println(obj.threeSum(arr, target));
    }

    public int threeSum(int[] nums, int target) {
        int result = 0;
        int diff = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (sum == target) return target;
                else if (Math.abs(sum-target) < diff) {
                    diff = Math.abs(sum - target);
                    result = sum;
                }
                if (sum < target) start++;
                else end--;
            }
        }
        return result;
    }
}

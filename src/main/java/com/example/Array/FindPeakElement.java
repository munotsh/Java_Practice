package com.example.Array;

public class FindPeakElement {
    public static void main(String[] args) {
        FindPeakElement obj = new FindPeakElement();
        int[] arr = {1, 2, 3, 1};
        // OP : index 2 (3) TC : O(logn)
        System.out.println(obj.findPeakNumberIndexWithBinarySearch(arr));
        System.out.println(obj.findPeakNumberIndexWithIteration(arr));
        System.out.println(obj.findPeakNumberWithRecursion(arr));
    }

    public int findPeakNumberIndexWithBinarySearch(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return 0;
        }
        if (nums[0] > nums[1]) {
            return 0;
        } else if (nums[len - 1] > nums[len - 2]) {
            return len - 1;
        }
        int l = 1;
        int h = len - 2;
        while (l <= h) {
            int mid = (l + h) / 2;
            if (nums[mid] > nums[mid + 1] && nums[mid] > nums[mid - 1]) return mid;
            else if (nums[mid] < nums[mid + 1]) l = mid + 1;
            else if (nums[mid] < nums[mid - 1]) h = mid - 1;
        }
        return 0;
    }

    public int findPeakNumberIndexWithIteration(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return 0;
        }
        if (nums[0] > nums[1]) {
            return 0;
        } else if (nums[len - 1] > nums[len - 2]) {
            return len - 1;
        }
        for (int i = 1; i < len - 1; i++) {
            if (nums[i] > nums[i + 1] && nums[i] > nums[i - 1]) {
                return i;
            }
        }
        return 0;
    }

    public int findPeakNumberWithRecursion(int[] nums) {
        return findPeak(nums, 0, nums.length -1);
    }
    int findPeak(int[] nums, int st, int ed){
        if(st<ed){
            int mid = (st+ed)/2;
            if(nums[mid]>nums[mid+1]){
                return findPeak(nums, st, mid);
            }
            return findPeak(nums, mid+1, ed);
        }else{
            return st;
        }
    }
}

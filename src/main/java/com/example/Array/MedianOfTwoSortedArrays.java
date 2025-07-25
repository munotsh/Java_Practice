package com.example.Array;

public class MedianOfTwoSortedArrays {
    public static void main(String args[])
    {
        MedianOfTwoSortedArrays medianOfTwoSortedArrays = new MedianOfTwoSortedArrays();
        int[] num1 = {7,12,14,13};
        int[] num2 = {1,2,3,4,9,11};
        //OP:8.00 TC: O(min(len1,len2)) and SC: O(1)
        System.out.println(medianOfTwoSortedArrays.findMedianSortedArrays(num1,num2));
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums2.length < nums1.length) return findMedianSortedArrays(nums2, nums1);
        int n1 = nums1.length;
        int n2 = nums2.length;
        int low = 0, high = n1;

        while(low <= high) {
            int cut1 = (low+high) / 2;
            int cut2 = (n1 + n2 + 1) / 2 - cut1;


            int left1 = cut1 == 0 ? Integer.MIN_VALUE : nums1[cut1-1];
            int left2 = cut2 == 0 ? Integer.MIN_VALUE : nums2[cut2-1];

            int right1 = cut1 == n1 ? Integer.MAX_VALUE : nums1[cut1];
            int right2 = cut2 == n2 ? Integer.MAX_VALUE : nums2[cut2];


            if(left1 <= right2 && left2 <= right1) {
                if( (n1 + n2) % 2 == 0 )
                    return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
                else
                    return Math.max(left1, left2);
            }
            else if(left1 > right2) {
                high = cut1 - 1;
            }
            else {
                low = cut1 + 1;
            }
        }
        return 0.0;
    }
}


package com.example.Array;

public class TrappingRainWater {
    public static void main(String[] args) {
        TrappingRainWater trappingRainWater = new TrappingRainWater();
//        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1}; // OP:6
        int[] height = {4, 2, 0, 3, 2, 5}; // OP:9
        System.out.println(trappingRainWater.trap(height));
    }

    public int trap(int[] height) {
        int n = height.length;
        int sum = 0;
        int maxL[] = new int[n];
        int maxR[] = new int[n];
        maxL[0] = height[0];
        for (int i = 1; i < n; i++) {
            maxL[i] = Math.max(height[i], maxL[i - 1]);
        }
        maxR[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            maxR[i] = Math.max(height[i], maxR[i + 1]);
        }

        for (int i = 0; i < n; i++) {
            sum = sum + Math.min(maxL[i], maxR[i]) - height[i];
        }
        return sum;
    }

//    public int trap(int[] height) {
//        int totalWater = 0;
//        if (height == null || height.length == 0) {
//            return totalWater;
//        }
//        int leftHighestBar = 0;
//        int rightHigestBar = 0;
//        for (int i = 0; i < height.length; i++) {
//            int currentBarHeight = height[i];
//            // As we already have traversed elements before, we know higest one on left
//            leftHighestBar = Math.max(leftHighestBar, currentBarHeight);
//            // we don't need to calculate right-highest again, as will be same unless we reach it.
//            if (i == 0 || currentBarHeight == rightHigestBar) {
//                rightHigestBar = findRightHighestBar(height, i);
//            }
//            // find the water availble on that given bar
//            int water = (Math.min(leftHighestBar, rightHigestBar) - currentBarHeight);
//            if (water > 0) {
//                totalWater = totalWater + water;
//            }
//        }
//        return totalWater;
//    }
//
//    public int findRightHighestBar(int[] height, int fromIndex) {
//        int highest = 0;
//        for (int i = fromIndex + 1; i < height.length; i++) {
//            if (highest < height[i]) {
//                highest = height[i];
//            }
//        }
//        return highest;
//    }
}

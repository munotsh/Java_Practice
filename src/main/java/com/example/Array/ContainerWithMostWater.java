package com.example.Array;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
        int[] arr = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(containerWithMostWater.maxArea(arr));
    }

    public int maxArea(int[] height) {
        int left = 0;
        int maxArea = -1;
        int area = 0;
        int right = height.length - 1;
        while (left < right) {
            area = Math.min(height[left], height[right]) * (right - left);
            if (area > maxArea)
                maxArea = area;
            if (height[left] < height[right])
                left++;
            else
                right--;

        }
        return maxArea;
    }
}

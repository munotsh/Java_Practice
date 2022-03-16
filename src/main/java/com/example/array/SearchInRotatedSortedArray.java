package com.example.array;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        SearchInRotatedSortedArray searchInRotatedSortedArray = new SearchInRotatedSortedArray();
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;
        System.out.println(searchInRotatedSortedArray.search(nums,target));
    }

    public int search(int[] arr, int x) {
        int low=0,high=arr.length-1;

        while(low<=high)
        {
            int mid=(low+high)/2;
            if(arr[mid]==x)
                return mid;

            if(arr[high] > arr[mid])
            {
                if(x <= arr[high] && x > arr[mid])
                    low = mid + 1;
                else
                    high=mid-1;
            }
            else
            {
                if(x < arr[mid] && x >= arr[low])
                    high = mid - 1;
                else
                    low = mid + 1;
            }
        }
        return -1;
    }
}

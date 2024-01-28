package com.example.companies.loblaw;

public class SearchElementInSortedMatrix {
    public static void main(String[] args) {
        int[][] arr = { {1, 5, 9}, {14, 20, 21}, {30, 34, 43} };
        int searchElement = 21;

        // better approach, as matrix is sorted by column-wise and row-wise.
        // using binary search O(log(m*n))
        System.out.println(findElement1(arr,searchElement));
        //compare last element of each row with searchElement,
        // if it searchElement is less then the element present in that only
//        System.out.println(findElement2(arr,searchElement));
    }

    private static boolean findElement1(int[][] arr, int searchElement) {
            int row = arr.length;
            int col = arr[0].length;
            int left = 0;
            int right = (row*col)-1;

            while(left<=right){
                int mid = (left+right)/2;
                if(arr[mid/row][mid%row] == searchElement)
                    return true;
                else if(arr[mid/row][mid%row] < searchElement){
                    left = mid+1;
                }
                else{
                    right = mid-1;
                }

            }

        return false;
    }


    private static boolean findElement2(int[][] arr, int searchElement) {
        int len = arr[0].length;
        for(int i=0;i<arr[0].length;i++){
            if(searchElement<=arr[i][arr[i].length-1]){
                for(int j=0;j<arr[i].length;j++){
                    if(searchElement == arr[i][j]){
                        System.out.println("{ "+i+","+j+"}"+"="+searchElement);
                        return true;
                    }
                }
//                System.out.println(i);
                break;
            }
        }
        return false;
    }
}

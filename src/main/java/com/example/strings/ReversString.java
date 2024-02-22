package com.example.strings;

public class ReversString {
    public static void main(String[] args) {
        String str = "Shailesh";
        System.out.println(reverseUsingStartEndPointers(str));//O(log(n)+O(n) to get char array)
        System.out.println(reverseUsingRecursion(str));//O(n)
    }

    private static String reverseUsingStartEndPointers(String str) {
        char[] arr = str.toCharArray();
        int start = 0;
        int end = arr.length-1;
        while(start<end){
            char ch = arr[start];
            arr[start] = arr[end];
            arr[end] = ch;
            start++;
            end--;
        }
        return String.valueOf(arr);
    }

    public static String reverseUsingRecursion(String str) {
        if ((null == str) || (str.length()  <= 1)) {
            return str;
        }
        return reverseUsingRecursion(str.substring(1)) + str.charAt(0);
    }
}

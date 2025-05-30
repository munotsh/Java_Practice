package com.example.strings;

public class ConvertStringToNumber {
    public static void main(String[] args) {
        System.out.println(addStrings("219"));
    }

    private static int addStrings(String str) {
        int num =0;
        for(char c:str.toCharArray()){
            num = num * 10 + (c - '0');
        }
        return num;
    }
}

package com.example.companies.intuit;

public class ConvertExcelColumnToNumber {
    public static void main(String[] args){
//        String s = "AA"; // 27
//        String s = "A"; // 26
//        String s = "AB"; // 28
        String s = "BZ"; // 78
        int result = 0;
        for(int i=0;i< s.length();i++){
            result = result * 26;
            result = result + (s.charAt(i) - 'A') + 1;
        }
        System.out.println(result);
    }
}

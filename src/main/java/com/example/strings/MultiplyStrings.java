package com.example.strings;

public class MultiplyStrings {
    public static void main(String[] args) {
        MultiplyStrings obj = new MultiplyStrings();
        System.out.println(obj.multiply("123", "456"));
    }

    public String multiply(String num1, String num2) {
        int i = num1.length() - 1;
        int position = 1;
        int numm1 = 0;
        while (i >= 0) {
            numm1 += (num1.charAt(i) - '0')*position;
            position *=10;
            i--;
        }

        position = 1;
        int j =num2.length()-1;
        int numm2 =0;
        while (j>=0){
            numm2 += (numm1 * (num2.charAt(j) - '0'))*position;
            position *=10;
            j--;
        }
        return  String.valueOf(numm2);
    }
}

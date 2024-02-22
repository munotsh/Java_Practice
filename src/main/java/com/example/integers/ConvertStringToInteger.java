package com.example.integers;

public class ConvertStringToInteger {
    public static void main(String[] args) {
        System.out.println(myAtoi("123"));
        System.out.println(myAtoi("   -42"));
        System.out.println(myAtoi("4193"));
    }

    public static long myAtoi(String s) {
        s = s.trim();
        if (s.length() == 0) {
            return 0;
        }

        int i = 0;
        long num = 0;
        boolean isNegative = false;

        // Check for sign
        if (s.charAt(i) == '+' || s.charAt(i) == '-') {
            isNegative = s.charAt(i++) == '-';
        }

        // Process digits
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i++) - '0';

            // Check for overflow
            if (num > (Integer.MAX_VALUE - digit) / 10) {
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }

            num = num * 10 + digit;
        }
        if (isNegative)
            num = -num;

        return (int) num;

    }
}

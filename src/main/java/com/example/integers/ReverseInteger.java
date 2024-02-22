package com.example.integers;

public class ReverseInteger {
    public static void main(String[] args){
        System.out.println(reversNumber(123));
        System.out.println(reversNumber(-123));
        System.out.println(reversNumber(120));
    }

    private static long reversNumber(int num) {
        long rev = 0;
        while(num !=0){
            if(rev > Integer.MAX_VALUE/10 || rev < Integer.MIN_VALUE/10){
                return 0;
            }
            rev = (rev*10) + num %10;
            num = num /10;
        }


        return rev;
    }
}

package com.example.ebay;

public class PowerOf {
    public static void main(String[] args){
System.out.println(pow(2.000,10));
        System.out.println(pow(2.100,3));
        System.out.println(pow(2.000,-2));

    }

    public static double pow(double x, double n){
        double result = 1;
        for(int i=0;i<Math.abs(n);i++){
            result *=x;
        }
        return result;
    }
}

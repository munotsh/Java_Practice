package com.example.strings;

public class AddStrings {
    public static void main(String[] args) {
        AddStrings obj = new AddStrings();
        System.out.println(obj.addStrings("219", "219"));
    }

    public String addStrings(String num1, String num2) {
        if(num1==null) return num2;
        if(num2==null) return num1;

        int i = num1.length()-1;
        int j = num2.length()-1;
        int carry =0;
        StringBuffer sb =new StringBuffer();
        while (i >= 0 || j >= 0) {
            int firstNum = i>=0? num1.charAt(i) - '0':0;
            int secondNum = j>=0? num2.charAt(j) - '0':0;
            int sum = carry+firstNum + secondNum;
            int current = sum%10;
            carry = sum/10;
            sb.append(current);
            i--;
            j--;
        }
        return sb.reverse().toString();
    }
}

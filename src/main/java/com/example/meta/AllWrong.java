package com.example.meta;

public class AllWrong {
    public static String getWrongAnswers(int N, String C) {
       StringBuffer sb = new StringBuffer();
       for(char ch:C.toCharArray()){
           sb.append(ch == 'A'? 'B':'A');
       }
        return sb.toString();
    }
    public static void main(String[] args){
System.out.println(getWrongAnswers(3,"ABA"));
    }
}

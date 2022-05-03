package com.example.stack;

import java.util.Stack;

public class BasicCalculatorII {
    public static void main(String[] args){
     BasicCalculatorII obj = new BasicCalculatorII();
     System.out.println(obj.calculate("30+2*2"));
    }

    public int calculate(String s) {
        s = s.replace(" ", "");
        Stack<Integer> stck = new Stack<Integer>();
        char op = '+';
        int res=0, num=0, len = s.length();
        for(int i=0; i<len; i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                //convert it to real number
                num = (num * 10) + (c - '0');
            }
            if((!Character.isDigit(c) && c!=' ')||i==len-1){
                if(op == '+'){
                    stck.push(num);
                }else if(op == '-'){
                    stck.push(-num);
                }else if(op == '*'){
                    stck.push(stck.pop()*num);
                }else if(op == '/'){
                    stck.push(stck.pop()/num);
                }
                num = 0;
                op = c;
            }
        }
        while(!stck.isEmpty()){
            res+=stck.pop();
        }
        return res;
    }
}

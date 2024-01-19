package com.example.allPracticeProgram.jpmc;

import java.util.Stack;

public class DecodeString {

	public static void main(String[] args) {
//		String s = "2[ab]";
		String s = "2[a2[b]]";
//		Stack<Integer> integerstack = new Stack<>();
//        Stack<Character> charstack = new Stack<>();
//        
//		char[] arr = s.toCharArray();
//		StringBuffer sb1 = new StringBuffer();
//		for(char ch:arr) {
//			if((ch>='a' && ch<='z')) {
//				charstack.push(ch);
////				System.out.println(ch+" = is char");
//			}
//			else if(ch>='0' && ch<'9') {
//				integerstack.push(Integer.valueOf(String.valueOf(ch)));
//			}
//			else if(ch=='[') {
//				charstack.push(ch);
////				System.out.println(ch+" = is opening bracket");
//			}
//			else if(ch==']') {
//				StringBuffer sb = new StringBuffer();
//				while(!charstack.peek().equals('[')) {
//					sb.append(charstack.pop());
//				}
//				int num = integerstack.pop();
//				for(int i=0;i<num;i++) {
//					sb1 = sb1.append(sb);
//				}
//				charstack.pop();
//				System.out.println(ch+" = is closing closing");
//			}
//		}
//		
//		System.out.println(sb1.reverse());
		
		
		System.out.println(decode(s));
		
	}
	
	
	
	static String decode(String str)
    {
        Stack<Integer> integerstack = new Stack<>();
        Stack<Character> stringstack = new Stack<>();
        String temp = "", result = "";
       
        for (int i = 0; i < str.length(); i++)
        {
            int count = 0;
       
            if (Character.isDigit(str.charAt(i)))
            {
                while (Character.isDigit(str.charAt(i)))
                {
                    count = count * 10 + str.charAt(i) - '0';
                    i++;
                }
       
                i--;
                integerstack.push(count);
            }
       
            else if (str.charAt(i) == ']')
            {
                temp = "";
                count = 0;
       
                if (!integerstack.isEmpty())
                {
                    count = integerstack.peek();
                    integerstack.pop();
                }
       
                while (!stringstack.isEmpty() && stringstack.peek()!='[' )
                {
                    temp = stringstack.peek() + temp;
                    stringstack.pop();
                }
       
                if (!stringstack.empty() && stringstack.peek() == '[')
                    stringstack.pop();
       
                for (int j = 0; j < count; j++)
                    result = result + temp;
       
                for (int j = 0; j < result.length(); j++)
                    stringstack.push(result.charAt(j));
       
                result = "";
            }
       
            else if (str.charAt(i) == '[')
            {
                if (Character.isDigit(str.charAt(i-1)))
                    stringstack.push(str.charAt(i));
       
                else
                {
                    stringstack.push(str.charAt(i));
                    integerstack.push(1);
                }
            }
       
            else
                stringstack.push(str.charAt(i));
        }
       
        while (!stringstack.isEmpty())
        {
            result = stringstack.peek() + result;
            stringstack.pop();
        }
       
        return result;
    }

}

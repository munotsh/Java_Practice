package com.example.allPracticeProgram.ola;

public class Alphanumeric {
	
	public static int p1;
	public static int p2;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int p=4;
		String s="abcd";
		System.out.println(divide(s, p));
		
		
	}
	
	public static String divide(String s,int p) {
		
//		if(p==0) {
//			return String.valueOf(s.charAt(p));	
//			}	
//		p1++;
//		p = p/2;
		
		int v = 0;
		int p3 =p;
		for(int i=0;i<p/2;i++) {
		v = p3/2;	
		}
		System.out.println(s.substring(0,v-1));
		return "";
		
	}
	
		
		
//		
//		String str1="Great Power";    
//		str1.toCharArray()
//        StringBuffer newStr=new StringBuffer(str1);    
//            
//        for(int i = 0; i < str1.length(); i++) {    
//                
//            //Checks for lower case character    
//            if(Character.isLowerCase(str1.charAt(i))) {    
//                //Convert it into upper case using toUpperCase() function    
//                newStr.setCharAt(i, Character.toUpperCase(str1.charAt(i)));    
//            }    
//            //Checks for upper case character    
//            else if(Character.isUpperCase(str1.charAt(i))) {    
//                //Convert it into upper case using toLowerCase() function    
//                newStr.setCharAt(i, Character.toLowerCase(str1.charAt(i)));    
//            }    
//        }    
//        System.out.println("String after case conversion : " + newStr);    
//    }    
//
//	}

}

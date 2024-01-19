package com.example.allPracticeProgram.volkswagen;

import java.lang.reflect.Array;
import java.nio.file.Path;
import java.nio.file.Paths;

public class VWTest {

	public static void main(String[] args) {
		int input1 =11;
		String input2 ="abcdefghijk";
		int count =0;
		StringBuffer sb = new StringBuffer();
		for(int i=input1;i>=1;) {
			if(i%2!=0 && i%3!=0) {
				sb.append(input2.charAt(i-1));
				i--;
				
			}
			else if(i%2==0) {
				if((i-1)/3<i/2) {
					
					sb.append(input2.charAt(i-1));
					i--;
					int i1 =i;
					sb.append("#");
					i--;
					sb.append(new StringBuffer(input2).reverse().substring((i1/3),i));
					sb.append("#");
					i = i1/3;
					i--;
				}
				else {
//					sb.append("#");
//					sb.append(new StringBuffer(input2).reverse().substring(i/3,i));
//						i = i/3;	
				}
				
				}
			
			else {
				sb.append(input2.charAt(i));
			}
			
		}
		System.out.println(sb.reverse().toString());
		
		
		
		
		
		
		
		
		// TODO Auto-generated method stub
//		
//		int x=10;
//		int y=20;
//		(x>y)?System.out.print(x):System.out.print(y);
	/*	
		System.out.println(some());	

	}
		static Boolean some(){
	while(true) {
		try {return true;}
		finally {break;
	}
	}
	return false;
	}*/

}
}

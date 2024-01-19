package com.example.allPracticeProgram.jpmc;

public class DecodeString2 {

	public static void main(String[] args) {
		char[] arr = "ofrsgkeeeekgs".toCharArray();
		String sb = new String();
		sb = String.valueOf(arr[0]);
		
		boolean flag =true;
		
		for(int i=1;i<arr.length;i++) {
			if(flag) {
				sb = String.valueOf(arr[i])+sb;
				flag= false;
			}
			else
			{
				sb = sb+String.valueOf(arr[i]);
				flag= true;
			}
		}
		System.out.println(sb);

	}

}

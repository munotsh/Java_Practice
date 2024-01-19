package com.example.allPracticeProgram.cisco;

public class HowManyWords {

	public static void main(String[] args) {

//		String s = "How many eggs are in a half-dosen, 13?";
//		String s = "he is a good programmer, he won 865 compitations, but sometimes he dont. what do you think? all test-cases should pass. done-done?";
		String s = "hdskjfh asdjklasjd ds  ramu 748 dj.";
		String[] arr = s.split(" ");
		int count = 0;
		for(int i=0;i<arr.length;i++) {
//			(.)*(\\d)(.)*
//			^[a-zA-Z]*$
			boolean isBrases = arr[i].contains("[") || arr[i].contains("]") || arr[i].contains("(") || arr[i].contains(")") || arr[i].contains("{") || arr[i].contains("}"); 
			if(!arr[i].equals("") && !isBrases && !arr[i].matches("(.)*(\\d)(.)*")) {
				count++;
				System.out.println(arr[i]);
			}
		}
		System.out.println(count);
//		s.matches("^[a-zA-Z]*$");
	}

}

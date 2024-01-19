package com.example.allPracticeProgram.jpmc;

public class Panagram {

	public static void main(String[] args) {
		
		String s = "The quick brown fox jumps over the lazy dog";
		
		char small = 'a';
		char upper = 'A';
		StringBuffer sb = new StringBuffer();
		while(small <= 'z' || upper <= 'Z') {
			if(!s.contains(String.valueOf(small)) && !s.contains(String.valueOf(upper))) {
				sb.append(String.valueOf(small));
			}
			small++;
			upper++;
		}
		if(sb.length() == 0) {
			System.out.println("null");
		}
		else {
			System.out.println(sb);
		}
		

	}

}

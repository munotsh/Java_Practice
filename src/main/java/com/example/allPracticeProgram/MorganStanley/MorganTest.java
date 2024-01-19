package com.example.allPracticeProgram.MorganStanley;

public class MorganTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "BZA";
//		String s = "ZNMD";
		int count=0;
		char[] ch = s.toCharArray();
		char ch1 = 'A';
		for(int i=0;i<ch.length;i++) {
			int cw =0;
			for(int j = ch1;j<= 'Z';j++) {
				
				if(ch[i] == j) {
					break;
				}
				cw++;
				if(j=='Z')
					j='A';
				
			}
			int acw=0;
			char ch2 = ch1;
			while(true) {
				if(ch2 == ch[i]) {
					break;
				}
				acw++;
				if(ch2 == 'A') {
					ch2 ='Z';
				}
				else {
					ch2--;
				}
			}
			count +=Math.min(cw,acw);
			ch1 = ch[i];
		}
		
		
		System.out.println(count);
		//A = 65
		//Z = 90
	}

}

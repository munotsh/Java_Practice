package com.example.allPracticeProgram.jpmc;

public class OddEvenWithStarAndUnderScorr {

	public static void main(String[] args) {
		
		String s = "98676555533";/*"21462675756";*/
		StringBuffer sb = new StringBuffer();
		int first = Integer.parseInt(String.valueOf(s.charAt(0)));
		boolean isEven = first % 2 == 0;
		sb.append(first);
		for (int i = 1; i < s.length(); i++) {
			int num = Integer.parseInt(String.valueOf(s.charAt(i)));
			if (num != 0) {
				if (num % 2 == 0 && isEven) {
						sb.append("*");
				} 
				else if(num % 2 != 0 && !isEven) {
						sb.append("-");
					}
				
				sb.append(num);
				isEven = num % 2 == 0;
			} else {
				sb.append(num);
			}
		}

		System.out.println(sb);

	}

}

package com.example.allPracticeProgram.morgan_stanley;

import java.util.regex.Pattern;

public class ValidEmail {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "julia0_@gmail.com";
		System.out.println(isValid(s));
		boolean validEmail = true;
		
		if(isValid(s)) {
			for(int i=0;i<s.indexOf("@");i++) {
				
				if(!(s.charAt(i)>='a' && s.charAt(i)<='z')) {
					validEmail = false;
					break;
				}
			}
			
		}
		
	}
	public static boolean isValid(String email)
    {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                            "[a-zA-Z0-9_+&*-]+)*@" +
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                            "A-Z]{2,7}$";
                              
        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }
}

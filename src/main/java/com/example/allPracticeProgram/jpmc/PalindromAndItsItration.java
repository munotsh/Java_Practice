package com.example.allPracticeProgram.jpmc;

import javax.rmi.CORBA.Util;

/*Given an integer, add it with the reverse of the value, and check if it�s a palindrome.
If it isn�t a palindrome, repeat the process until the sum is a palindrome.
Print out the number of iterations and the value of the final palindrome.
https://codereview.stackexchange.com/questions/121644/reverse-digits-and-add-until-a-palindrome-appears
https://javaconceptoftheday.com/how-to-reverse-and-add-number-until-you-get-palindrome/ (solution added below)*/

public class PalindromAndItsItration {
	public static void main(String[] args) {
		
        System.out.println(reverseAndAdd(7325));
        System.out.println(reverseAndAdd(121));
        String s =new String();
	}
	
	static int reverseAndAdd(int number)
    {
		int count=0; 
		 int reverse = reverseNumber(number);
        if(checkPalindrome(number))
        {
        	System.out.println(1);
        	reverse = reverseNumber(number);
            return number+reverse;
        }
        else
        {
            while (!checkPalindrome(number))
            {
               reverse = reverseNumber(number);
                int sum = number + reverse;
                number = sum;
                count++;
            }
        }
        
        System.out.println(count);
        return number;
    }
	
	 static boolean checkPalindrome(int number)
	    {
	        int reverse = reverseNumber(number);
	        if(reverse == number)
	        {
	            return true;
	        }
	        else
	        {
	            return false;
	        }
	    }
	 
	 static int reverseNumber(int number)
	    {
	        int reverse = 0;
	        int rem = 0;
	        while (number != 0)
	        {
	            rem = number % 10;
	            reverse = (reverse*10) + rem;
	            number = number/10;
	        }
	        return reverse;
	    }
}

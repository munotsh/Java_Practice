package com.example.allPracticeProgram.nagarro;

public class ShortestSubString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
String s1 = "My name is Fran";
String s2 = "rim";

System.out.println(Minimum_Window(s1.toCharArray(), s2.toCharArray()));
	}
	
	static String Minimum_Window(char []s, char []t)
	{
	 
	    int m[] = new int[256];
	    int ans = Integer.MAX_VALUE; // length of ans
	    int start = 0; // starting index of ans
	    int count = 0;
	    // creating map
	    for (int i = 0; i < t.length; i++) {
	        if (m[t[i]] == 0)
	            count++;
	        m[t[i]]++;
	    }
	 
	    // References of Window
	    int i = 0;
	    int j = 0;
	 
	    // Traversing the window
	    while (j < s.length)
	    {
	       
	        // Calculations
	        m[s[j]]--;
	        if (m[s[j]] == 0)
	            count--;
	 
	        // Condition matching
	        if (count == 0)
	        {
	            while (count == 0)
	            {
	               
	                // Sorting ans
	                if (ans > j - i + 1)
	                {
	                    ans = Math.min(ans, j - i + 1);
	                    start = i;
	                }
	               
	                // Sliding I
	                // Calculation for removing I
	                m[s[i]]++;
	                if (m[s[i]] > 0)
	                    count++;
	 
	                i++;
	            }
	        }
	        j++;
	    }
	 
	    if (ans != Integer.MAX_VALUE)
	        return String.valueOf(s).substring(start, ans+start);
	    else
	        return "-1";
	}

}

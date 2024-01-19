package com.example.allPracticeProgram.cisco;

import java.util.Map;
import java.util.TreeMap;

public class CSTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		palindromeSubStrs("tacoca");
//		palindromeSubStrs("aaa");
		System.out.println(countPS("aaa"));
		System.out.println(countPS("tacocat"));
		
	}
	
//	 static void palindromeSubStrs(String s)
//	    {
//	        //map<string, int> m;
//	        TreeMap<String , Integer> m = new TreeMap<>();
//	        int n = s.length();
//	       
//	        // table for storing results (2 rows for odd-
//	        // and even-length palindromes
//	        int[][] R = new int[2][n+1];
//	       
//	        // Find all sub-string palindromes from the 
//	        // given input string insert 'guards' to 
//	        // iterate easily over s
//	        s = "@" + s + "#";
//	       
//	        for (int j = 0; j <= 1; j++)
//	        {
//	            int rp = 0;   // length of 'palindrome radius'
//	            R[j][0] = 0;
//	       
//	            int i = 1;
//	            while (i <= n)
//	            {
//	                //  Attempt to expand palindrome centered 
//	                // at i
//	                while (s.charAt(i - rp - 1) == s.charAt(i + 
//	                                                j + rp))
//	                    rp++;  // Incrementing the length of
//	                           // palindromic radius as and 
//	                           // when we find vaid palindrome
//	       
//	                // Assigning the found palindromic length
//	                // to odd/even length array
//	                R[j][i] = rp;
//	                int k = 1;
//	                while ((R[j][i - k] != rp - k) && (k < rp))
//	                {
//	                    R[j][i + k] = Math.min(R[j][i - k], 
//	                                              rp - k);
//	                    k++;
//	                }
//	                rp = Math.max(rp - k,0);
//	                i += k;
//	            }
//	        }
//	       
//	        // remove 'guards'
//	        s = s.substring(1, s.length()-1);
//	       
//	        // Put all obtained palindromes in a hash map to
//	        // find only distinct palindromess
//	        m.put(s.substring(0,1), 1);
//	        for (int i = 1; i < n; i++)
//	        {
//	            for (int j = 0; j <= 1; j++)
//	                for (int rp = R[j][i]; rp > 0; rp--)
//	                   m.put(s.substring(i - rp - 1,  i - rp - 1 
//	                                       + 2 * rp + j), 1);
//	            m.put(s.substring(i, i + 1), 1);
//	        }
//	       
//	        // printing all distinct palindromes from 
//	        // hash map
//	       System.out.println("Below are " + (m.size())
//	                           + " palindrome sub-strings");
//	         
//	       for (Map.Entry<String, Integer> ii:m.entrySet())
//	          System.out.println(ii.getKey());
//	    }
	
	
	static int countPS(String str)
    {
        int N = str.length();
 
        // create a 2D array to store the count
        // of palindromic subsequence
        int[][] cps = new int[N][N];
 
        // palindromic subsequence of length 1
        for (int i = 0; i < N; i++)
            cps[i][i] = 1;
 
        // check subsequence of length L is
        // palindrome or not
        for (int L = 2; L <= N; L++) {
            for (int i = 0; i <= N-L; i++) {
                int k = L + i - 1;
              if (str.charAt(i) == str.charAt(k)) {
                cps[i][k] = cps[i][k - 1]
                                    + cps[i + 1][k] + 1;
              }else{
                cps[i][k] = cps[i][k - 1]
                                    + cps[i + 1][k]
                                    - cps[i + 1][k - 1];
              }
            }
        }
 
        // return total palindromic subsequence
        return cps[0][N - 1];
    }

}

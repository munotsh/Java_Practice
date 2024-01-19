package com.example.allPracticeProgram.ict;

import java.util.Arrays;
import java.util.HashMap;

public class Newtest {
	
	static void sort(String []s, int n)
	{
	    for (int i=1 ;i<n; i++)
	    {
	        String temp = s[i];
	 
	        // Insert s[j] at its correct position
	        int j = i - 1;
	        while (j >= 0 && temp.length() < s[j].length())
	        {
	            s[j+1] = s[j];
	            j--;
	        }
	        s[j+1] = temp;
	    }
	}
	static void printArraystring(String str[], int n)
	{
	    for (int i=0; i<n; i++)
	        System.out.print(str[i]+" ");
	}
	public static String printl_ongestWord(String arr[])
	{
	    HashMap<String, Boolean> map = new HashMap<String, Boolean>();
	    for (String str : arr)
	    {
	        map.put(str, true);
	    }
	    //Arrays.sort(arr, new LengthComparatorQ); // Sort by length
	    sort(arr,arr.length);
	    printArraystring(arr, arr.length);
	    for (String s : arr)
	    {
	        if (canBuildWord(s, true, map))
	        {
	            System.out.println(s);
	            return s;
	        }
	    }
	  return "";
	 }
	 static boolean canBuildWord(String str, boolean isOriginalWord,
	 HashMap<String, Boolean> map)
	 {
	    if (map.containsKey(str) && !isOriginalWord)
	    {
	        return map.get(str);
	    }
	    for (int i = 1; i < str.length(); i++)
	    {
	        String left = str.substring(0, i);
	        String right = str.substring(i);
	        if (map.containsKey(left) && map.get(left) == true &&
	            canBuildWord(right, false, map))
	        {
	            return true;
	        }
	    }
	 map.put(str, false);
	 return false;
	 }
	 public static void main(String args[])
		{
		    //String []arr = {"GeeksforGeeks", "I", "from", "am"};
		    String []arr = {"test", "tester", "Phenomenologically", "testertest","testing","TestingTester","TestingTester"};
		    int n = arr.length;
		     
		    // Function to perform sorting
		  //  sort(arr,n);
		    // Calling the function to print result
		   System.out.println(printl_ongestWord(arr));
		     
		}

}

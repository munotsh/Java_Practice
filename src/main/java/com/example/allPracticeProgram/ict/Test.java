package com.example.allPracticeProgram.ict;
import java.util.*;
public class Test {

	

	// C++ implementation of the approach
	//C++ TO JAVA CONVERTER WARNING: The following #include directive was ignored:
	//#include <bits/stdc++.h>

	// Comparator to sort the string by
	// their lengths in decreasing order
	private boolean compare(String s1, String s2)
	{
		return s1.length() > s2.length();
	}

	// Function that returns true if string s can be
	// made up of by other two string from the array
	// after concatenating one after another
	private static boolean canbuildword(String s, boolean isoriginalword, TreeMap<String, Boolean> mp)
	{

		// If current string has been processed before
		if (mp.containsKey(s) && mp.get(s) == false)
		{
			return false;
		}

		// If current string is found in the map and
		// it is not the string under consideration
		if (mp.containsKey(s) && mp.get(s) == true && isoriginalword == false)
		{
			return true;
		}

		for (int i = 1; i < s.length(); i++)
		{

			// Split the string into two
			// contiguous sub-strings
			String left = s.substring(0, i);
			String right = s.substring(i);

			// If left sub-string is found in the map and
			// the right sub-string can be made from
			// the strings from the given array
			if (mp.containsKey(left) && mp.get(left) == true && canbuildword(right, false, mp))
			{
				return true;
			}
		}

		// If everything failed, we return false
		mp.put(s, false);
		return false;
	}

	// Function to return the longest string
	// that can made be made up from the
	// other string of the given array
	private static String printlongestword(ArrayList<String> listofwords)
	{

		// Put all the strings in the map
		TreeMap<String, Boolean> mp = new TreeMap<String, Boolean>();
		for (String s : listofwords)
		{
			mp.put(s, true);
		}

		// Sort the string in decreasing
		// order of their lengths
	//C++ TO JAVA CONVERTER TODO TASK: The 'Compare' parameter of std::sort produces a boolean value, while the Java Comparator parameter produces a tri-state result:
	//ORIGINAL LINE: sort(listofwords.begin(), listofwords.end(), compare);
		Collections.sort(listofwords);

		// Starting from the longest string
		for (String s : listofwords)
		{

			// If current string can be made
			// up from other strings
			if (canbuildword(s, true, mp))
			{
				return s;
			}
		}

		return "-1";
	}

	// Driver code
	public static void main(String[] args)
	{
		ArrayList<String> listofwords = new ArrayList<String>(Arrays.asList("geeks", "for", "geeksfor", "geeksforgeeks"));
		System.out.print(printlongestword(new ArrayList<String>(listofwords)));

	}

}

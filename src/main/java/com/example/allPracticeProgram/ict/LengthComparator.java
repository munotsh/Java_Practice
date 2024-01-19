package com.example.allPracticeProgram.ict;

import java.util.Comparator;

public abstract class LengthComparator implements Comparator {
	 public int compare (String s1 ,String s2)
     {
          if ( s1.length() > s2.length() ) return -1;
          if ( s1.length() < s2.length() ) return 1;
          return 0;
     }
}


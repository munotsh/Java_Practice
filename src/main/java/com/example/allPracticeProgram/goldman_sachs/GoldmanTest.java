package com.example.allPracticeProgram.goldman_sachs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GoldmanTest {
	
	 static class Pair {
			String str;
			int count;

			Pair (String str, int count) {
				this.str = str;
				this.count = count;
			}
		}
	 
	 public static List<String> getShrunkArray(List<String> inputArray, int burstLength) {
			int n = inputArray.size();
			List<String> outputArray = new ArrayList<String>();
			
			Stack<Pair> stk = new Stack<Pair>();

			int count = 1;
			for (int i = 0; i < n; i++) {
				if (stk.isEmpty()) {
					stk.push(new Pair(inputArray.get(i), 1));
				}
				else if ((stk.peek().str).equals(inputArray.get(i))) {
					count = stk.peek().count + 1;
					stk.push(new Pair(inputArray.get(i), count));
					if (count >= burstLength) {
						while (count-- > 0) {
							stk.pop();
						}
					}
				}
				else {
					stk.push(new Pair(inputArray.get(i), 1));
				}
			}
			for (int i = 0; i < stk.size(); i++) {
				outputArray.add(stk.get(i).str);
			}

			return outputArray;
		}
//	 public static List<String> getShrunkArray(List<String> inputArray, int burstLength) {
//			int i = 0;
//			while (i < inputArray.size()) {
//				if (i < 0)
//					i = 0;
//				int count = 1, j = i+1;
//				while (j < inputArray.size() && inputArray.get(j).equals(inputArray.get(i))) {
//					count++;
//					j++;
//				}
//				if (count >= burstLength) {
//					while (count-- > 0) {
//						inputArray.remove(i);
//					}
//					i-=2;
//				}
//				i++;
//			}
//			return inputArray;
//		}
	 
//	 public static List<String> getShrunkArray(List<String> inputArray, int burstLength) {
//	 List<String> result = new ArrayList<>();
//	    boolean isBurst=false;
//
//	    int i = 0;
//	    int j = 1;
//	    int n = inputArray.size();
//	    int count = 0;
//	    while (i < n) {
//	        isBurst=false;
//	        count++;
//
//	        while (j<n && inputArray.get(i).equals(inputArray.get(j))) {
//	            if (++count >= burstLength) isBurst = true;
//	            j++;
//	        }
//
//	        while (count > 0) {
//	            count--;
//	            i=j;
//	            if (!isBurst) result.add(inputArray.get(i-1));
//	        }
//	        j++;
//	    }
//	    return result;
//	 }

	public static void main(String[] args) {
		
		ArrayList<String> inputArray = new ArrayList<String>();
		inputArray.add("a");
		inputArray.add("b");
		inputArray.add("c");
		inputArray.add("c");
		inputArray.add("c");
		inputArray.add("d");
		inputArray.add("e");
		inputArray.add("e");
		System.out.println(getShrunkArray(inputArray,3));

		

	}

}

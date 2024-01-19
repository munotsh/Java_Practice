package com.example.allPracticeProgram.amazon;

import java.util.Arrays;

public class Password {

	public static void main(String[] args) {
//		String str="good";
		String str = "test";
		System.out.println("All substring of abbc are:");
		int sum = 0;
		int len = str.length();
		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j <= len; j++) {
//			   String input = str.substring(i,j);
				long u = str.substring(i, j).chars().distinct().count();
				System.out.println(str.substring(i, j) + u);
				sum = (int) (sum + u);
			}
		}
		System.out.println(sum);
//		System.out.println(uniqueLetterString(str));

	}

//	public static int uniqueLetterString(String s) {
//        int n = s.length();
//        int res = 0;
//        for (int i = 0; i < n; i += 1) {
//            int l = i - 1;
//            while (l >= 0) {
//                if (s.charAt(l) == s.charAt(i)) break;
//                l -= 1;
//            }
//            int r = i + 1;
//            while (r < n) {
//                if (s.charAt(r) == s.charAt(i)) break;
//                r += 1;
//            }
//            res += (r - i) * (i - l);
//        }
//        return res;
//    }

//	public static int uniqueLetterString(String str) {
//        int res = 0;
//        for (int j = 0; j < 26; j++) {
//            //for each possible character, mark down the appeared index in the string into a list
//            char ch = (char)('A' + j);
//            List<Integer> position = new ArrayList<>();
//            for (int i = 0; i < str.length(); i++) {
//                if (str.charAt(i) == ch) {
//                    position.add(i);
//                }
//            }
//            
//            int p = 0;
//            int s = 0;
//            
//            for (int i = 0; i < position.size(); i++) {
//                //special case, first apperance
//                if (i == 0) {
//                    p = position.get(i);
//                } else {
//                    p = position.get(i) - position.get(i-1) - 1;
//                }
//                
//                //special case, last apperance
//                if (i == position.size() - 1) {
//                    s = str.length() - position.get(i) - 1;
//                } else {
//                    s = position.get(i + 1) - position.get(i) - 1;
//                }
//                
//                res += s*p + s + p + 1;
//                
//                /* AABAAA
//                 for ch B: p = 2 s = 3
//                 possible substring:
//                 BA, BAA, BAAA(s)
//                 AB, AAB(p)
//                 AABA, AABAA, AABAAA, ABA, ABAA, ABAAA(p*s)
//                 B(1)
//                */
//            }
//        }
//        return res;
//    }

//public static int uniqueLetterString(String s) {
//        
//		int[] lastSeen = new int[26];
//        Arrays.fill(lastSeen, -1);
//        
//        int[] secLastSeen = new int[26];
//        Arrays.fill(secLastSeen, -1);
//		
//		int count = 0, res = 0;
//	
//		for (int i = 0; i < s.length(); i++) {
//            int idx = s.charAt(i) - 'A';
//            int p = lastSeen[idx];
//            int q = secLastSeen[idx];
//			
//            count += i - p - p + q;
//            res += count;
//            
//            secLastSeen[idx] = lastSeen[idx];
//            lastSeen[idx] = i;
//		}
//        
//		return res;
//    }

//	 private static final int MOD = 1000_000_007;
//	    private static Map<Character, TreeSet<Integer>> charPos = new HashMap<>();
//
//	    public static int uniqueLetterString(String s) {
//	        int ans = 0;
//	        initCharPos(s);
//	        for (int i = 0; i < s.length(); i++) {
//	            Character c = s.charAt(i);
//	            final int prev = getPrev(s, i);
//	            final int next = getNext(s, i);
//	            // Every character c contributes to unique characters from prev -> next
//	            final int contributions = (i - prev) * (next - i);
//	            // System.out.println(String.format("(%d) %c [%d, %d]\t%d", i, c, prev, next, contributions));
//	            ans += contributions % MOD;
//	        }
//	        return ans % MOD;
//	    }
//	    
//	    private static void initCharPos(String s) {
//	        for (int i = 0; i < s.length(); i++) {
//	            Character c = s.charAt(i);
//	            charPos.computeIfAbsent(c, x -> new TreeSet<>()).add(i);
//	        }
//	    }
//	    
//	    private static int getNext(String s, int pos) {
//	        Character c = s.charAt(pos);
//	        Integer next = charPos.get(c).ceiling(pos+1);
//	        return next == null ? s.length() : next;
//	    }
//	    
//	    private static int getPrev(String s, int pos) {
//	        Character c = s.charAt(pos);
//	        Integer prev = charPos.get(c).floor(pos-1);
//	        return prev == null ? -1 : prev;
//	    }

//	public static int uniqueLetterString(String s) {
//        final int n = s.length();
//		int[] prev = new int[26];
//		int[] contribution = new int[26];
//		Arrays.fill(prev, -1);
//		int cur = 0, res = 0;
//		int mod = 1000000007;
//
//		for (int i = 0; i < n; i++) {
//			int idx = s.charAt(i) - 'A';
//			cur -= contribution[idx]; // if exist duplication, minus the previous contribution
//			contribution[idx] = i - prev[idx]; // calculate increase g(x)
//			cur += contribution[idx]; // current contribution f(x) = f(x-1) + g(x);
//			res += cur % mod;
//			prev[idx] = i;
//		}
//
//		return res;
//    }

//	static int MOD = 1000_000_007;
//
//	public static int uniqueLetterString(String s) {
//	            
//	            int[] first_instance = new int[26];
//	            int[] second_instance = new int[26];
//
//	            int ret_val = 0, dp_val = 0;
//
//	           int cnt = 0;
//	            for(char i : s.toCharArray()){
//
//	                int ind_val = i - 'A';
//
//	                dp_val += (++cnt - first_instance[ind_val] + ( second_instance[ind_val] - first_instance[ind_val]));
//
//
//	                ret_val = (ret_val + dp_val) % MOD;
//
//
//	                second_instance[ind_val] = first_instance[ind_val];
//	                first_instance[ind_val] = cnt;
//
//	            }
//	    
//
//	            return ret_val;
//	    }

	public static int uniqueLetterString(String s) {
		int MODULUS = 1000000007;
		int result = 0;
		int prev = 0;
		int[] start = new int[26];
		int[] end = new int[26];
		Arrays.fill(start, -1);
		Arrays.fill(end, -1);
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			prev = (prev + i - end[ch - 'A'] - 1) % MODULUS;
			prev -= (end[ch - 'A'] - start[ch - 'A']) % MODULUS;
			prev++;
			result = (result + prev) % MODULUS;
			start[ch - 'A'] = end[ch - 'A'];
			end[ch - 'A'] = i;
		}
		return result;
	}

}

package com.example.allPracticeProgram.amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SumOfPair {

	public static void main(String[] args) {
		ArrayList<Integer> s = new ArrayList<Integer>();
//		s.add(6);
//		s.add(1);
//		s.add(3);
//		s.add(46);
//		s.add(1);
//		s.add(3);
//		s.add(9);
		
		long z = 12;
		
		
		int count =0;
		int sum = (int)z;
		
		
		s.add(6);
		s.add(6);
		s.add(3);
		s.add(9);
		s.add(3);
		s.add(5);
		s.add(1);
		List<Integer> result = new ArrayList<Integer>();
		Map<Integer,Integer> map = new HashMap<Integer, Integer>();
		for(Integer k : s)
		{
			if(result.isEmpty())
			{
				result.add(sum-k);
			}
			else if(result.contains(k))
			{	 
//					System.out.println((sum-k)+" "+k);
				if(!map.containsKey(k))
					map.put(sum-k, k);
				
					count++;
					result.add(sum-k);
			}
			 else
			 {
				 result.add(sum-k);
			 }
		}
//		System.out.println(count/2);
		System.out.println(map);
//		int count1= 0;
//		for(Map.Entry<Integer, Integer> m:map.entrySet()) {
//			if(map.containsKey(m.getValue())) {
//				count1++;
//			}
//		}
//		System.out.println(count1);
//
//		cntDisPairs(s,s.size()-1,sum);
		
	}
	
	
	static int cntDisPairs(ArrayList<Integer> arr,
            int N, int K)
{

// Stores count of distinct pairs
// whose sum equal to K
int cntPairs = 0;

// Store frequency of each distinct
// element of the array
HashMap<Integer,Integer> cntFre = new HashMap<Integer,Integer>();

for (int i = 0; i < N; i++)
{

    // Update frequency
    // of arr[i]
    if(cntFre.containsKey(arr.get(i)))
        cntFre.put(arr.get(i), cntFre.get(arr.get(i) + 1));
     
    else
        cntFre.put(arr.get(i), 1);
}

// Traverse the map
for (Map.Entry<Integer,Integer> it : cntFre.entrySet())
{

    // Stores key value
    // of the map
    int i = it.getKey();

    // If i is the half of K
    if (2 * i == K)
    {

        // If frequency of i
        // greater than  1
        if (cntFre.get(i) > 1)
            cntPairs += 2;
    }

    else
    {
        if (cntFre.containsKey(K - i))
        {

            // Update cntPairs
            cntPairs += 1;
        }
    }
}

// Update cntPairs
cntPairs = cntPairs / 2;
return cntPairs;
}

}

package com.example.allPracticeProgram.amazon;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Test12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] arr = { 1, 2, 3, 4, 5 };
		System.out.println(maximumQuality(Arrays.asList(arr), 2));
	}

	private static long maximumQuality(List<Integer> packets, int channels) {
		CopyOnWriteArrayList<Integer> a = new CopyOnWriteArrayList<Integer>();
		for (Integer i : packets) {
			a.add(i);
		}
//	if(channels > packets.size()):
//        return false
		long servers = 0;
		long ele = 0;
		for (int i = 0; i < channels; i++) {
			ele = Collections.max(a);
			a.remove(ele);
		}

		servers = servers + ele;
		return (long) Math.ceil(median(a) + servers);
	}

	public static long median(List<Integer> a) {
		int n = a.size();
		// First we sort the array
		Collections.sort(a);

		// check for even case
		if (n % 2 != 0)
			return (long) a.get(n / 2);

		return (long) ((long) (a.get((n - 1) / 2) + a.get(n / 2)) / 2.0);
	}

//	private static long maximumQuality(List<Integer> packets, int channels) {
//        if (packets == null || packets.size() == 0) return 0L;
//        if (packets.size() == 1) return (long) packets.get(0);
//        if (channels <= 0) {
//            // TODO.. throw exception, bad input
//        }
//        
////        packets = packets.OrderBy(x => x).ToList();
//        Collections.sort(packets);
//        int n = channels - 1;
//        int median = 0;
//        while (n-- > 0) {
//            int val = packets.get(packets.size()-1);
//            median += val;
//            packets.remove(packets.size()-1);
//        }
//        long result = findMedian(packets, median);
//        return result;
//    }
//        private static long findMedian(List<Integer> list, long median) {
//        long val = 0;
//        if (list.size() %2 == 0) {
//          //  val = (long) (list[list.Count()/2]  + list[list.Count()/2 - 1])/2;
//            val = (long) Math.ceil((((double)list.get(list.size()/2) + (double)list.get(list.size()/2 - 1)))/2);
//        } else {
//            val = (long) list.get(list.size()/2);
//        }
//        return (long) (val + median);
//    }
}

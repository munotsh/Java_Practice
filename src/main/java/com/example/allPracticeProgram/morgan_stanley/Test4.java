package com.example.allPracticeProgram.morgan_stanley;

import java.util.HashSet;
import java.util.Set;

public class Test4 {

	public static void main(String[] args) {

		decres(2);
//		HashSet<Object> set = new HashSet<Object>();
//		KeyMaster k1 = new KeyMaster("aardvark");
//		KeyMaster k2 = new KeyMaster("aardvark");
//		String s1 = new String("aardvark");
//		String s2 = new String("aardvark");
//		set.add(k1);
//		set.add(k2);
//		set.add(s1);
//		set.add(s2);
//		System.out.println(set.size());
//		set.add(k1);set.add(k1);
//		set.add(k2); set.add(k2);
//		System.out.print(set.size()+":");
//		k2.i =1;
//		System.out.print(set.size()+":");
//		set.remove(k1);
//		System.out.print(set.size()+":");
//		set.remove(k2);
//		System.out.print(set.size());
//		System.out.println("1 ");
//		synchronized (args) {
//			System.out.println("2 ");
//			try {
//				args.wait();
//			}catch (InterruptedException e) {
//				
//			}
//		}
//		System.out.println("3 ");
	}

	private static void decres(int i) {

		if(i>=0) {
			decres(i-1);
		}
		System.out.println(i);
	}

}

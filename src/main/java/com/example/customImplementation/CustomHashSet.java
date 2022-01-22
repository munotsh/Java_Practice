package com.example.customImplementation;

import java.util.HashMap;
public class CustomHashSet<E> {
	private HashMap<E, Object> hashMap;

	public CustomHashSet() {
		hashMap = new HashMap<>();
	}

	public void add(E value) {
		hashMap.put(value, null);
	}

	public boolean contains(E obj) {
		return hashMap.keySet().contains(obj);
	}

	public void display() {
		hashMap.keySet().forEach(System.out::println);
	}

	public boolean remove(E obj) {
		if(hashMap.keySet().contains(obj)) {
			hashMap.remove(obj);
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		CustomHashSet<Integer> customHashSet = new CustomHashSet<Integer>();
		customHashSet.add(21);
		customHashSet.add(25);
		customHashSet.add(30);
		customHashSet.add(33);
		customHashSet.add(35);
		System.out.println("customHashSet contains 21 =" + customHashSet.contains(21));
		System.out.println("customHashSet contains 51 =" + customHashSet.contains(51));
		System.out.print("Displaying customHashSet: ");
		customHashSet.display();
		System.out.println("\n\n21 removed: " + customHashSet.remove(21));
		System.out.println("22 removed: " + customHashSet.remove(22));
		System.out.print("Displaying customHashSet: ");
		customHashSet.display();
	}
}

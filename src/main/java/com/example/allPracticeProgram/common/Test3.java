package com.example.allPracticeProgram.common;

public class Test3 {

	public static void main(String[] args) {

		ImmutableClassEmployee im = new ImmutableClassEmployee("abc", "Shailesh",new Address("Pune"));
		
		System.out.println("name = "+im.getName());
		System.out.println("pan = "+im.getPancardNumber());
		System.out.println("city = "+im.getAddress().getCity());
		
		System.out.println("--------------------------");
		System.out.println(im.getAddress());
		im.getAddress().setCity("banglor");
		System.out.println(im.getAddress());
		System.out.println("name = "+im.getName());
		System.out.println("pan = "+im.getPancardNumber());
		System.out.println("city = "+im.getAddress().getCity());
		
	
	}

}

package com.example.allPracticeProgram.MorganStanley;

public class SampleTest {
	
		public static void main(String[] args) {
		// TODO Auto-generated method stub
			Animal a1=new Animal("Lion");
			Animal a2=new Animal("Crocodile");
			System.out.println("Before swap: a1:" + a1 + "; a2:"+ a2);
			swap(a1,a2);
			System.out.println("After swap: a1:" + a1 + "; a2:"+ a2);
		
	}
		public static void swap(Animal an1,Animal an2) {
			Animal tmp= new Animal("");
			tmp=an1;
			an1=an2;
			an2=tmp;
		}

}
class Animal{
	String name;
	public Animal(String name) {
		this.name=name;
	}
	public String toString() {
		return name;
	}
	}

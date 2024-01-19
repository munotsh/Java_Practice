package com.example.allPracticeProgram.nexer.simple1;

public class pair_hash {
	public double key;
	public double value;
	public pair_hash(double key, double value) {
		this.key = key;
		this.value = value;
	}
	public int functorMethod( int key,int value)
	{
		return key * 31 + value;
	}

	
}

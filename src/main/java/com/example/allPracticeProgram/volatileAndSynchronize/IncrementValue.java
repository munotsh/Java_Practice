package com.example.allPracticeProgram.volatileAndSynchronize;

public class IncrementValue {
private  int i;

public int getI() {
	return i;
}

public synchronized void setI() {
	this.i++;
}

}

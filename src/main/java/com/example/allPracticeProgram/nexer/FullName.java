package com.example.allPracticeProgram.nexer;

public class FullName {

	String childName;
	String fatherName;
	String motherName;
	double bloodCount;
	
	public FullName(String childName, String fatherName, String motherName) {
		this.childName = childName;
		this.fatherName = fatherName;
		this.motherName = motherName;
	}
	
	public String getChildName() {
		return childName;
	}
	
	public String getFatherName() {
		return fatherName;
	}
	
	public String getMotherName() {
		return motherName;
	}
	
	public double getBloodCount() {
		return bloodCount;
	}

	public void setBloodCount(double bloodCount) {
		this.bloodCount = bloodCount;
	}
}

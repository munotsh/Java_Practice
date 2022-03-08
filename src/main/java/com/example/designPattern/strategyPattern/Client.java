package com.example.designPattern.strategyPattern;

public class Client {
	public static void main(String[] args) {
		Employee ram = new Employee("Ram",new SoftwareDeveloper());
		Employee rahul = new Employee("Rahul",new SeniorSoftwareDeveloper());
		System.out.println("---------before promotion------------");
		ram.doWork();
		rahul.doWork();
		ram.promote(new SeniorSoftwareDeveloper());
		rahul.promote(new TeamLead());
		System.out.println("---------after promotion------------");
		ram.doWork();
		rahul.doWork();
	}
}

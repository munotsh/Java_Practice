package com.example.allPracticeProgram.nexer;

import java.util.ArrayList;
import java.util.List;

public class RoyalBlood2 {

	public static void main(String[] args) {

//		String king = "andrew";
//		List<FullName> relations = new ArrayList<FullName>();
//		relations.add(new FullName("betsy", "andrew", "flora"));
//		relations.add(new FullName("carol", "andrew", "betsy"));
//		relations.add(new FullName("dora", "andrew", "carol"));
//		relations.add(new FullName("elena", "andrew", "dora"));
//		List<String> claimants = new ArrayList<String>();
//		claimants.add("carol");
//		claimants.add("dora");
//		claimants.add("elena");
//		claimants.add("flora");
//		claimants.add("gloria");
//		int n = 4;
//		int m = 5;

		String king = "edwardi";
		List<FullName> relations = new ArrayList<FullName>();
		relations.add(new FullName("charlesi", "edwardi", "diana"));
		relations.add(new FullName("philip", "charlesi", "mistress"));
		relations.add(new FullName("wilhelm", "mary", "philip"));
		relations.add(new FullName("matthew", "wilhelm", "helen"));
		relations.add(new FullName("edwardii", "charlesi", "laura"));
		relations.add(new FullName("alice", "laura", "charlesi"));
		relations.add(new FullName("helen", "alice", "bernard"));
		relations.add(new FullName("henrii", "edwardii", "roxane"));
		relations.add(new FullName("charlesii", "elizabeth", "henrii"));
		List<String> claimants = new ArrayList<String>();
		claimants.add("charlesii");
		claimants.add("matthew");
		int n = 9;
		int m = 2;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				relations.get(j).setBloodCount((find(relations, relations.get(j).getFatherName(), king)
						+ find(relations, relations.get(j).getMotherName(), king)) / 2);
			}
		}
		relations.stream().forEach(r -> System.out.println(r.getChildName() + " = " + r.getBloodCount()));

		double max = 0;
		String name = "";

		for (int i = 0; i < relations.size(); i++) {
			if (claimants.contains(relations.get(i).getChildName()) && max < relations.get(i).getBloodCount()) {
				max = relations.get(i).getBloodCount();
				name = relations.get(i).getChildName();
			}
		}

		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println(name + " = " + max);
	}

	private static double find(List<FullName> relations, String parentName, String king) {
		double count = 0;
		if (parentName.equals(king)) {
			count = 100;
		}
		for (int i = 0; i < relations.size(); i++) {
			if (parentName.equals(relations.get(i).getChildName())) {
				count = relations.get(i).getBloodCount();
			}
		}
		return count;
	}

}

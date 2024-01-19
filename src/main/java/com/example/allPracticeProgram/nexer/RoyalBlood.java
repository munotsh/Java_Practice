package com.example.allPracticeProgram.nexer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RoyalBlood {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		String relationAndClaimant = scanner.nextLine();
		String[] a = relationAndClaimant.split(" ");
		int relation = Integer.parseInt(a[0]);
		int claimant = Integer.parseInt(a[1]);
		
		String king = scanner.nextLine();
		
		List<FullName> relations = new ArrayList<FullName>();
		for(int i=0;i<relation;i++) {
			String fn = scanner.nextLine();
			String[] splitFN = fn.split(" ");
			relations.add(new FullName(splitFN[0], splitFN[1], splitFN[2]));
		}
		List<String> claimants = new ArrayList<String>();
		for(int i=0;i<claimant;i++) {
			claimants.add(scanner.nextLine());
		}

		for (int i = 0; i < relation; i++) {
			for (int j = 0; j < relation; j++) {
				relations.get(j).setBloodCount((find(relations, relations.get(j).getFatherName(), king)
						+ find(relations, relations.get(j).getMotherName(), king)) / 2);
			}
		}

		double max = 0;
		String heirName = "";

		for (int i = 0; i < relations.size(); i++) {
			if (claimants.contains(relations.get(i).getChildName()) && max < relations.get(i).getBloodCount()) {
				max = relations.get(i).getBloodCount();
				heirName = relations.get(i).getChildName();
			}
		}

		relations.stream().forEach(r -> System.out.println(r.getChildName() + " = " + r.getBloodCount()));
		System.out.println(heirName);
	}

	private static double find(List<FullName> relations, String parentName, String king) {
		double bldCount = 0;
		if (parentName.equals(king)) {
			bldCount = 100;
		}
		else {
			for (int i = 0; i < relations.size(); i++) {
				if (parentName.equals(relations.get(i).getChildName())) {
					bldCount = relations.get(i).getBloodCount();
					break;
				}
			}	
		}
		
		return bldCount;
	}
}



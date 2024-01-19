package com.example.allPracticeProgram.nexer.simple;

import java.util.ArrayList;
import java.util.Scanner;

public class problemC {
	public static final int MAXY = 1000;
	public static final int MAXX = 1000;
	public static final int MINY = 0;
	public static final int MINX = 0;

	public static void main(String[] args) {
		ArrayList<SprinklerRangeArea> waterSprinklers = new ArrayList<SprinklerRangeArea>();
		Scanner scanner = new Scanner(System.in);
		int numOfWaterSprinklers = Integer.parseInt(scanner.nextLine());
		while(numOfWaterSprinklers>0) {
			String s = scanner.nextLine();
			String[] details = s.split(" ");
			waterSprinklers.add(new SprinklerRangeArea(Integer.parseInt(details[0]),Integer.parseInt(details[1]),Integer.parseInt(details[2])));
			numOfWaterSprinklers--;
		}

		ArrayList<EvaluateArea> groups = new ArrayList<EvaluateArea>();
		EvaluateArea newgroup = new EvaluateArea();
		newgroup.add_circle(waterSprinklers.get(0));
		groups.add(newgroup);

		for (int i = 1; i < waterSprinklers.size(); i++) {
			boolean no_group = true;
			for (EvaluateArea g : groups) {
				if (g.is_intersect(waterSprinklers.get(i))) {
					g.add_circle(waterSprinklers.get(i));
					no_group = false;
					break;
				}
			}
			if (no_group) {
				EvaluateArea newgroup1 = new EvaluateArea();
				newgroup1.add_circle(waterSprinklers.get(i));
				groups.add(newgroup1);
			}
		}

		float entery = MAXY;
		float exity = MAXY;
		boolean found = true;
		for (EvaluateArea g : groups) {
			if ((g.miny < MINY) && (g.maxy > MAXY)) {
				found = false;
				break;
			}
			if (g.upper_starty > entery) {
				entery = g.lower_starty;
			}
			if (g.upper_endy > exity) {
				exity = g.lower_endy;
			}
		}

		if (found) {
			System.out.printf("%.2f", (float) MINX);
			System.out.print(" ");
			System.out.printf("%.2f", entery);
			System.out.print(" ");
			System.out.printf("%.2f", (float) MAXX);
			System.out.print(" ");
			System.out.printf("%.2f", exity);
		} else {
			System.out.println("IMPOSSIBLE");
		}
	}
}


package com.example.allPracticeProgram.nexer.simple1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class problemC {
	public static final int MAXY = 1000;
	public static final int MAXX = 1000;
	public static final int MINY = 0;
	public static final int MINX = 0;

	public static void main(String[] args) {
		ArrayList<Circle> waterSprinklers = new ArrayList<Circle>();
		Scanner scanner = new Scanner(System.in);
		int numOfWaterSprinklers = Integer.parseInt(scanner.nextLine());
		while(numOfWaterSprinklers>0) {
			String s = scanner.nextLine();
			String[] details = s.split(" ");
			waterSprinklers.add(new Circle(Integer.parseInt(details[0]),Integer.parseInt(details[1]),Integer.parseInt(details[2])));
			numOfWaterSprinklers--;
		}

//		pair<float,float> enter = make_pair(0, MAXY);
//        deque<pair<float,float>> mystack; 
//        mystack.push_back(enter);
//        pair<float,float>* cp;
//        bool found = false;
//        unordered_set<pair<float, float>, pair_hash> visited;
		
		pair_hash ph = new pair_hash(0, MAXY);
		Stack<pair_hash> mystack = new Stack<pair_hash>(); 
		mystack.push(ph);
		pair_hash cp = null;
		boolean found = false;
		List<pair_hash> visited = new ArrayList<pair_hash>();
		
		while (!mystack.empty()){
			
			cp = mystack.peek(); 
            if (cp.key == MAXX) {
                found = true;
                break;
            }
            visited.add(cp);
            
            if (cp.value > MAXY || cp.value < MINY || cp.key < MINX ) {
                visited.add(cp);
                mystack.pop();
                continue;
            }
            
            if (!test_sprinkles(waterSprinklers,cp))  {      
                continue;
            }
            
            pair_hash newpair = new pair_hash(cp.key, cp.value + 1);
            if (visited.get(newpair) == visited.end())  {      
                mystack.push_back(newpair);
                continue;
            }
            else visited.insert(newpair);
            
            
		}
		
		
		
		
		
		
//		ArrayList<EvaluateArea> groups = new ArrayList<EvaluateArea>();
//		EvaluateArea newgroup = new EvaluateArea();
//		newgroup.add_circle(waterSprinklers.get(0));
//		groups.add(newgroup);
//
//		for (int i = 1; i < waterSprinklers.size(); i++) {
//			boolean no_group = true;
//			for (EvaluateArea g : groups) {
//				if (g.is_intersect(waterSprinklers.get(i))) {
//					g.add_circle(waterSprinklers.get(i));
//					no_group = false;
//					break;
//				}
//			}
//			if (no_group) {
//				EvaluateArea newgroup1 = new EvaluateArea();
//				newgroup1.add_circle(waterSprinklers.get(i));
//				groups.add(newgroup1);
//			}
//		}
//
//		float entery = MAXY;
//		float exity = MAXY;
//		boolean found = true;
//		for (EvaluateArea g : groups) {
//			if ((g.miny < MINY) && (g.maxy > MAXY)) {
//				found = false;
//				break;
//			}
//			if (g.upper_starty > entery) {
//				entery = g.lower_starty;
//			}
//			if (g.upper_endy > exity) {
//				exity = g.lower_endy;
//			}
//		}
//
//		if (found) {
//			System.out.printf("%.2f", (float) MINX);
//			System.out.print(" ");
//			System.out.printf("%.2f", entery);
//			System.out.print(" ");
//			System.out.printf("%.2f", (float) MAXX);
//			System.out.print(" ");
//			System.out.printf("%.2f", exity);
//		} else {
//			System.out.println("IMPOSSIBLE");
//		}
	}

	static boolean test_sprinkles(List<Circle> sprinkles, pair_hash p){


	    for (int k = 0; k < sprinkles.size(); k++)
	        if (sprinkles.get(k).isWet(p)) 
	        	return false; 
	    return true;

	}
}


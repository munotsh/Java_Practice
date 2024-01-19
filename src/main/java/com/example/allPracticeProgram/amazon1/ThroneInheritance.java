package com.example.allPracticeProgram.amazon1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ThroneInheritance {
	Map<String, LinkedList<String>> graph = null;
	Set<String> deaths = new HashSet<>();
	String king = null;

	public ThroneInheritance(String kingName) {
		this.king = kingName;
		this.graph = new HashMap<>();
		this.graph.put(kingName, new LinkedList<>());
	}

	public void birth(String parentName, String childName) {
		this.graph.putIfAbsent(parentName, new LinkedList<>());
		this.graph.get(parentName).add(childName);
	}

	public void death(String name) {
		deaths.add(name);
	}

	public List<String> getInheritanceOrder() {
		List<String> inheritance = new ArrayList<>();
		dfs(king, inheritance);
		return inheritance;
	}

	void dfs(String src, List<String> inheritance) {
		if (!deaths.contains(src)) {
			inheritance.add(src);
		}

		LinkedList<String> destinations = this.graph.get(src);
		if (destinations == null)
			return;
		for (String destination : destinations) {
			dfs(destination, inheritance);
		}
	}

	public static void main(String[] args) {
		String[] instructions = { "ThroneInheritance", "birth", "birth", "birth", "birth", "birth", "birth",
				"getInheritanceOrder", "death", "getInheritanceOrder" };

		String[][] params = { { "king", "andy" }, { "king", "bob" }, { "king", "catherine" }, { "andy", "matthew" },
				{ "bob", "alex" }, { "bob", "asha" }, { null }, { "bob" } };

		int count = 0;

		ThroneInheritance obj = null;
		for (String s : instructions) {
			if (s.equals("ThroneInheritance"))
				obj = new ThroneInheritance("king");
			if (s.equals("birth")) {
				obj.birth(params[count][0], params[count][1]);
				System.out.println("null");
				count++;
			}
			if (s.equals("getInheritanceOrder")) {
				List<String> order = obj.getInheritanceOrder();
				System.out.println(order);
				count++;
			}
			if (s.equals("death")) {
				obj.death(params[count][0]);
				System.out.println("null");
				count++;
			}
		}

	}

}

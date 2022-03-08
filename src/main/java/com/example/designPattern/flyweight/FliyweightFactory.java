package com.example.designPattern.flyweight;

import java.util.HashMap;
import java.util.Map;

public class FliyweightFactory {
	private static Map<String, Vehical> map = new HashMap<String, Vehical>();

	public static Vehical getInstence(String type) throws Exception {
		Vehical v = null;
		if (map.containsKey(type)) {
			v = map.get(type);
		} else {
			switch (type) {
			case "Cycle":
				v = new Cycle();
				break;
			case "Truck":
				v = new Truck();
				break;
			default:
				throw new Exception("Unknown Type = " + type);
			}
			map.put(type, v);
		}
		return v;

	}
}

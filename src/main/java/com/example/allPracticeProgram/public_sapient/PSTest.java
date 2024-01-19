package com.example.allPracticeProgram.public_sapient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PSTest {

	public static void main(String[] args) {
		Map<String,String> m = new HashMap<>();
		  m.put("s","s");
		  m.put("A","A");
		  List<String> a = m.entrySet().stream()
		              .map(e -> e.getKey()).collect(Collectors.toList());
		  a.stream().forEach(System.out::println);
	}

}

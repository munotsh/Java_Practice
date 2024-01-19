package com.example.allPracticeProgram.amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;

public class VancouerAmazon {

	Map<String,List<Integer>> m = new HashMap<>(); 
	public void hit(String url,Integer time) {
		if(m.containsKey(url)) {
			m.get(url).add(time);
		}else {
			List<Integer> lx = new ArrayList<>();
			lx.add(time);
			m.put(url,lx);
		}
		//m.get(url).removeIf(e->e>System.currentTimeMillis()-5000);
		m.get(url).removeIf(e->e>2);
	}

	public List<String> maxHit(int x){
		Queue<String> q = new PriorityQueue<String>((n1,n2)->m.get(n2).size()-m.get(n1).size());
		//m.entrySet().stream().forEach(e->e.getValue().removeIf(y->y>System.currentTimeMillis()-5000));
		m.entrySet().stream().forEach(e->e.getValue().removeIf(y->y>2));
		m.keySet().forEach(n->q.add(n));
		return q.stream().limit(x).collect(Collectors.toList());
	}
	public static void main(String[] args) {
		VancouerAmazon v = new VancouerAmazon();
		v.hit("a",1);
		v.hit("a", 2);
		v.hit("a", 3);
		v.hit("b", 2);
		v.hit("b", 1);
		v.hit("b", 1);
		v.hit("b", 1);
		v.hit("c", 4);
		System.out.println(v.maxHit(1));
	

}
}

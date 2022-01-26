package com.example.graph;

import java.util.*;

public class ReconstructItinerary {
    public static void main(String[] args) {
        //TC : O(E-log-E), E = tickets.length
        ReconstructItinerary reconstructItinerary = new ReconstructItinerary();
        //String[][] matrix = {{"MUC", "LHR"}, {"JFK", "MUC"}, {"SFO", "SJC"}, {"LHR", "SFO"}};
        //output : [JFK, MUC, LHR, SFO, SJC]
        String[][] matrix = {{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}};
        //output : [JFK, ATL, JFK, SFO, ATL, SFO]
        List<List<String>> tickets = new ArrayList<>();
        for (String[] s : matrix) {
            tickets.add(Arrays.asList(s));
        }
        List<String> result = reconstructItinerary.findItinerary(tickets);
        System.out.println(result);
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        LinkedList<String> res = new LinkedList<>();
        if (tickets == null) return null;

        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for (List<String> s : tickets) {
            String key = s.get(0);
            String value = s.get(1);
            map.putIfAbsent(key, new PriorityQueue<>());
            map.get(key).add(value);
        }

        dfs("JFK", map, res);
        return res;
    }

    private void dfs(String start, Map<String, PriorityQueue<String>> map, LinkedList<String> res) {
        PriorityQueue<String> arrivals = map.get(start);
        while (arrivals != null && !arrivals.isEmpty()) {
            dfs(arrivals.poll(), map, res);
        }
        res.addFirst(start);
    }
}

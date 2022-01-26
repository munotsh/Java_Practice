package com.example.graph;

import java.util.*;

public class EvaluateDivision {
    public static void main(String[] args) {
        EvaluateDivision evaluateDivision = new EvaluateDivision();
        //input 1
        //String[][] eq = {{"a","b"},{"b","c"},{"bc","cd"}};
        //double[] values = {1.5,2.5,5.0};
        //String[][] que = {{"a","c"},{"c","b"},{"bc","cd"},{"cd","bc"}};
        //Output: [3.75000,0.40000,5.00000,0.20000]

        //input 2
          String[][] eq = {{"a", "b"}, {"b", "c"}};
          double[] values = {2.0, 3.0};
          String[][] que = {{"a", "c"}, {"b", "a"}, {"a", "e"}, {"a", "a"}, {"x", "x"}};
        //Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]
        List<List<String>> equations = new ArrayList<>();
        for (String[] e : eq) {
            equations.add(Arrays.asList(e));
        }


        List<List<String>> queries = new ArrayList<>();
        for (String[] q : que) {
            queries.add(Arrays.asList(q));
        }
        double[] res = evaluateDivision.calcEquation(equations, values, queries);
        Arrays.stream(res).forEach(System.out::println);
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> map = buildGraph(equations, values);

        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String src = queries.get(i).get(0);
            String dest = queries.get(i).get(1);
            Set<String> visited = new HashSet<>();
            res[i] = dfs(src, dest, visited, map);
        }

        return res;
    }

    private Map<String, Map<String, Double>> buildGraph(List<List<String>> equations, double[] values) {
        Map<String, Map<String, Double>> map = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            String source = equations.get(i).get(0);
            String destination = equations.get(i).get(1);

            map.putIfAbsent(source, new HashMap<>());
            map.putIfAbsent(destination, new HashMap<>());
            map.get(source).put(destination, values[i]);
            map.get(destination).put(source, 1 / values[i]);
        }
        return map;
    }

    private double dfs(String src, String dest, Set<String> visited, Map<String, Map<String, Double>> map) {
        if (!map.containsKey(src) || !map.containsKey(dest))
            return -1;
        if (src.equals(dest))
            return 1;
        if (map.get(src) != null && map.get(src).get(dest) != null)
            return map.get(src).get(dest);
        visited.add(src);

        Map<String, Double> m = map.get(src);
        for (String s : m.keySet()) {
            double ans = dfs(s, dest, visited, map);
            if (ans != -1)
                return ans * m.get(s);
        }
        return -1;
    }
//        if (m.containsKey(dest)) {
//            return m.get(dest);
//        } else {
//            for (Map.Entry<String, Double> e : m.entrySet()) {
//                if (!visited.contains(e.getKey())) {
//                    double ans = dfs(e.getKey(), dest, visited, map);
//                    if (ans != -1)
//                        return ans * e.getValue();
//                }
//            }
//        }
//        return-1;
//}

}

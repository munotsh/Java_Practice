package com.example.graph;

import javax.swing.*;
import java.util.*;

public class SequenceReconstruction {
    public static void main(String[] args) {
        SequenceReconstruction sequenceReconstruction = new SequenceReconstruction();
        int[] org = {1, 2, 3};
        Integer[][] s = {{1, 2}, {1, 3}, {2, 3}};
        List<List<Integer>> seqs = new ArrayList<>();
        for (Integer[] i : s)
            seqs.add(Arrays.asList(i));
        System.out.println(sequenceReconstruction.generateSequence(org, seqs));
    }

    private boolean generateSequence(int[] org, List<List<Integer>> seqs) {
        if (org == null || org.length == 0) {
            return false;
        }

        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        HashMap<Integer, Integer> indegree = new HashMap<>();

        // 1. intitial map and count indegree
        int n = org.length;
        for (List<Integer> list : seqs) {
            if (list.size() == 1) {
                int a = list.get(0);
                if (!map.containsKey(a)) {
                    map.put(a, new HashSet<>());
                    indegree.put(a, indegree.getOrDefault(a, 0));
                }
            } else if (list.size() > 1) {
                for (int i = 1; i < list.size(); i++) {
                    int a = list.get(i - 1);
                    int b = list.get(i);
                    if (!map.containsKey(a)) {
                        map.put(a, new HashSet<>());
                        indegree.put(a, indegree.getOrDefault(a, 0));
                    }
                    if (!map.get(a).contains(b)) {
                        map.get(a).add(b);
                        indegree.put(b, indegree.getOrDefault(b, 0) + 1);
                    }
                }
            }
        }

        if (indegree.size() != n) {
            return false;
        }

        // BFS
        Queue<Integer> queue = new LinkedList<>();
        // put integer that indegree = 0 into queue
        for (int d : indegree.keySet()) {
            if (indegree.get(d) == 0) {
                queue.offer(d);
            }
        }

        int index = 0;
        while (!queue.isEmpty()) {
            if (queue.size() > 1) {
                return false;
            }

            int cur = queue.poll();
            if (index == n || org[index++] != cur) {
                return false;
            }
            // index++;

            if (map.containsKey(cur)) {
                for (int i : map.get(cur)) {
                    indegree.put(i, indegree.get(i) - 1);
                    if (indegree.get(i) == 0) {
                        queue.offer(i);
                    }
                }
            }
        }

        return index == n;
    }
}

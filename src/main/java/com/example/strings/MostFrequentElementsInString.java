package com.example.strings;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MostFrequentElementsInString {
    public static void main(String[] args) {
        String str = "Shailesh";
        System.out.println(findMostFrequentElement(str));
    }

    private static List<Character> findMostFrequentElement(String str) {
        str = str.toLowerCase();
        //Using stream only one value will be return
//    return str.chars().mapToObj(c -> (char)c)
//    .collect(Collectors.groupingBy(c -> (char)c,Collectors.counting()))
//    .entrySet().stream().peek(System.out::println)
//    .max(Map.Entry.comparingByValue()).get().getKey();


        // another way where we can have multiple character with same frequency
        Map<Character, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        for (char c : str.toCharArray()) {
            map.putIfAbsent(c, 0);
            map.put(c, map.get(c) + 1);
            max = Integer.max(max, map.get(c));
        }
        List<Character> result = new ArrayList<>();
        for(Map.Entry<Character,Integer> e:map.entrySet()){
            if(e.getValue() == max)
                result.add(e.getKey());
        }
        return result;

    }
}

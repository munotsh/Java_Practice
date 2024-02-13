package com.example.companies.ripple;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortingDataWithinDictionaries {
    public static void main(String[] args){
        List<String> dictionary = new ArrayList<>();
        dictionary.add("Shailesh");
        dictionary.add("Neha");
        dictionary.add("Sagar");
        dictionary.add("Akash");
        dictionary.add("Roshan");
        dictionary.add("Yash");
        dictionary.add("Sachin");
        dictionary.add("Ritesh");
        dictionary.add("Punya");
        dictionary.add("Pritam");
        dictionary.add("Shaailesh");
        dictionary = dictionary.stream().sorted((a,b) -> b.compareTo(a)).collect(Collectors.toList());
//    dictionary = dictionary.stream()
//                .sorted(Comparator.comparing(String::toUpperCase)).collect(Collectors.toList());

        System.out.println(dictionary);
    }
}

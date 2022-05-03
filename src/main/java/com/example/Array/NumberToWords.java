package com.example.Array;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class NumberToWords {
    String[] base = new String[] {"", "Thousand", "Million", "Billion"};
    String[] digit0 = new String[]{"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
            "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] digit1 = new String[] {"Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    public static void main(String[] args) {
    NumberToWords numberToWords = new NumberToWords();
    System.out.println(numberToWords.numberToWords(23456));
    }
    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        Deque<String> deque = new ArrayDeque<>();
        int i = 0;
        while (num > 0) {
            String current = getNum(num % 1000, base[i]);
            if (!current.isEmpty()) {
                deque.addFirst(current);
            }
            num = num / 1000;
            i++;
        }
        return String.join(" ", deque);
    }

    private String getNum(int num, String currentBase) {
        if (num == 0) return "";
        List<String> sb = new ArrayList<>();
        if (num >= 100) {
            sb.add(digit0[num / 100 - 1]);
            sb.add("Hundred");
            num = num % 100;
        }
        if (num >= 20) {
            sb.add(digit1[(num - 20) / 10]);
            num = num % 10;
        }
        if (num != 0) {
            sb.add(digit0[num - 1]);
        }
        if (!currentBase.isEmpty()) {
            sb.add(currentBase);
        }
        return String.join(" ", sb);
    }
}

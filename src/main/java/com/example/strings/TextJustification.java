package com.example.strings;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    public static void main(String[] args) {
        TextJustification obj = new TextJustification();
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;
        System.out.println(obj.fullJustify(words, maxWidth));
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int word = 0;
        while (word < words.length) {
            int j = word - 1;
            int characters = 0;
            // Max words that can be adjust in one line
            while (j + 1 < words.length && characters + words[j + 1].length() + j + 1 - word <= maxWidth) {
                j++;
                characters += words[j].length();
            }
            result.add(line(words, word, j, characters, maxWidth));
            word = j+1;
        }
        return result;
    }

    private String line(String[] words, int start, int end, int lineLen, int max) {
        StringBuffer sb = new StringBuffer();
        int p = 1, q = 0;
        if (start != end) {
            p = (max - lineLen) / (end - start);
            q = (max - lineLen) % (end - start);
        }
        for (int i = start; i <= end; i++) {
            sb.append(words[i]);
            if (i != end) {
                if (end == words.length - 1) sb.append(" ");
                else {
                    for (int j = 1; j <= p; j++) sb.append(" ");
                    // add extra spaces
                    if (q-- >= 1) sb.append(" ");
                }
            }
        }
        // add spaces in last line
        while (sb.length() < max) sb.append(" ");
        return sb.toString();
    }
}
//        int space = 0;
//        int len = 0;
//        int start = 0;
//        StringBuffer sb = new StringBuffer();
//        for (int i = 0; i < words.length; i++) {
//            len += words[i].length();
//            if (len + space < maxWidth) {
//                space++;
//            } else {
//                len -= words[i].length();
//                space -= 1;
//                i--;
//                int totalSpace = (maxWidth - len);
//                int j = start;
//                while (totalSpace > 0) {
//                    words[j] += " ";
//                    if (j+1 == i) {
//                        j = start;
//                    }
//                    else
//                    j++;
//                    totalSpace--;
//                }

//                start = i + 1;
//                len =0;
//                space = 0;
//            }
//        }


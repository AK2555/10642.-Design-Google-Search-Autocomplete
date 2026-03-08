package org.example;



import java.util.*;

public class Main {

    public static void main(String[] args) {

        SearchAutocomplete autocomplete = new SearchAutocomplete(
                new String[]{"he#llo world", "hi there", "hello", "hi world"},
                new int[]{4, 3, 2, 2}
        );

        int step = 1;

        List<String> res1 = autocomplete.getSuggestions('h');
        System.out.println(step++ + ". Input: h -> Output: " + res1);
        // Expected: [hello world, hi there, hello]

        List<String> res2 = autocomplete.getSuggestions('i');
        System.out.println(step++ + ". Input: i -> Output: " + res2);
        // Expected: [hi there, hi world]

        List<String> res3 = autocomplete.getSuggestions(' ');
        System.out.println(step++ + ". Input: ' ' -> Output: " + res3);
        // Expected: []

        List<String> res4 = autocomplete.getSuggestions('#');
        System.out.println(step++ + ". Input: # -> Output: " + res4);
        // Expected: []
        // Explanation: "hi " is stored as a new sentence with frequency 1
    }
}


package org.example.streamsexamples;

import java.util.Arrays;
import java.util.List;

public class StringExample3 {
    public static void main(String[] args) {
        reducestring();
        longestString();

    }

    private static void longestString() {
        List<String> words = Arrays.asList("apple", "banana", "kiwi", "strawberry");
        System.out.println(words.stream()
                .reduce("", (a, b) -> a.length() > b.length() ? a : b));
    }

    private static void reducestring() {
        List<String> words = Arrays.asList("Hello", "World");
        words.stream()
                .reduce("", (s1, s2) -> s1 + s2);
    }
}

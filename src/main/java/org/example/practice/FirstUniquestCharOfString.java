package org.example.practice;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FirstUniquestCharOfString {
    public static void main(String[] args) {
        System.out.println(findFirstUnique("aabbcde"));   // c
        System.out.println(findFirstUnique("aabb"));      // null
        System.out.println(findFirstUnique("swiss"));     // w
        System.out.println(findFirstUnique("java"));      // j
        System.out.println(findFirstUnique("leetcode"));  // l

    }

    public static Character findFirstUnique(String input) {
        return input.chars()                          // IntStream of char values
                .mapToObj(c -> (char) c)                 // convert to Character
                .collect(Collectors.groupingBy(
                        Function.identity(),                  // group by character
                        LinkedHashMap::new,                   // preserve insertion order
                        Collectors.counting()                 // count occurrences
                ))
                .entrySet().stream()
                .filter(e -> e.getValue() == 1)          // keep only unique chars
                .map(Map.Entry::getKey)
                .findFirst()                              // first unique one
                .orElse(null);                            // null if none found
    }
}

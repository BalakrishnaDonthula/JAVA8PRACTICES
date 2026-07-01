package org.example.streams;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SecondNonRepeating {
    public static void main(String[] args) {
        String str = "aabccdeff";
        str.chars()
                .mapToObj(i -> (char) i)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey)
                .skip(1)
                .findFirst()
                .ifPresent(System.out::println);
    }
}

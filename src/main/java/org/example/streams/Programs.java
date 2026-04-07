package org.example.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Programs {
    public static void main(String[] args) {
        //filterEvenNumbers();
        findDuplicate();
        // findSum();

    }

    private static void findSum() {
        List<Integer> list = List.of(1, 2, 3, 4, 5);
        int sum = list.stream()         // source
                .filter(n -> n % 2 == 0)   // intermediate (lazy)
                .mapToInt(Integer::intValue)// intermediate (lazy)
                .sum();
        System.out.println(sum);
    }

    private static void findDuplicate() {
        Optional<String> result = Stream.of("alpha", "beta", "gamm", "delta")
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return s.length() > 4;
                })
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .findFirst(); // short-circuit: stops after first match
        System.out.println(result.get());
    }

    private static void filterEvenNumbers() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> evenNos = numbers.stream()
                .filter(n -> n % 2 == 0)
                .toList();// Filter even numbers; // Print each even number
        System.out.println(evenNos);
    }
}

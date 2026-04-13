package org.example.streams;

import java.util.*;
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
        List<Integer> numbers = Arrays.asList(1, 2, 3, 2, 5, 3, 7, 5, 9);
        Set<Integer> set = new HashSet<>();
        Set<Integer> unique = numbers.stream()
                .filter(number -> !set.add(number))
                .collect(Collectors.toSet());
        System.out.println(unique);

    }

    private static void filterEvenNumbers() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> evenNos = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toUnmodifiableList());// Filter even numbers; // Print each even number
        evenNos.add(11);

        //System.out.println(evenNos);
    }
}

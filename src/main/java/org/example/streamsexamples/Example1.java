package org.example.streamsexamples;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Example1 {
    public static void main(String[] args) {

        // printTheElments();
        //StreamofArrary();
        //printRandomElments();
        //printNumberswithinrange();
        //convertArraytoList();
        //createAstreamMapKeys();
        //convertSetToList();
        //countTheelements();
        //partitioningby();
        //groupByFirstChar();
        //filterTheelem();
        peekmethod();

    }

    private static void peekmethod() {
        Stream.of(1, 2, 3)
                .peek(n -> System.out.println("Before: " + n))
                .map(n -> n * 2)
                .peek(n -> System.out.println("After: " + n))
                .collect(Collectors.toList());
    }

    private static void filterTheelem() {
        List<String> names = List.of("Balu", "Riyansh", "Aarush", "Geetha");
        names.stream().filter(name -> name.length() > 4)
                .forEach(name -> System.out.println(name));
    }

    private static void groupByFirstChar() {
        List<String> names = List.of("Balu", "Riyansh", "Aarush", "Geetha");
        names.stream().collect(Collectors.groupingBy(ch -> ch.charAt(0))).forEach((k, v) -> System.out.println(k + "  " + v));
    }

    private static void partitioningby() {
        List<Integer> list = IntStream.range(0, 10).boxed().collect(Collectors.toList());
        Map<Boolean, List<Integer>> elments = list.stream().collect(Collectors.partitioningBy(x -> x % 2 == 0));
        System.out.println(elments);

    }

    private static void countTheelements() {
        List<Integer> list = IntStream.range(0, 10).boxed().collect(Collectors.toList());

        System.out.println(list.stream().count());

    }

    private static void convertSetToList() {
        Set<String> set = Set.of("x", "y", "z");
        set.stream().collect(Collectors.toList()).forEach(System.out::println);
    }

    private static void createAstreamMapKeys() {
        Map<String, Integer> map = Map.of("one", 1, "two", 2, "three", 3, "four", 4);
        map.entrySet().stream().forEach(e -> System.out.println(e.getKey() + "=" + e.getValue()));
    }

    private static void convertArraytoList() {
        int[] intArray = {1, 2, 3, 4, 5};
        Arrays.stream(intArray)
                .boxed()
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    private static void printNumberswithinrange() {
        IntStream.rangeClosed(4, 1).forEach(System.out::println);
    }

    private static void StreamofArrary() {
        String[] arr = {"apple", "banana", "cherry"};
        Stream.of(arr).forEach(System.out::println);
        Arrays.stream(arr).forEach(System.out::println);

    }

    private static void printTheElments() {
        List<Integer> list = List.of(1, 2, 3, 4, 5);
        list.forEach(System.out::println);
    }

    private static void printRandomElments() {
        Stream.generate(Math::random).limit(6).forEach(System.out::println);
    }

}
